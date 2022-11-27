package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JsonDSL._
import org.json4s.{JArray, JValue}
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{MetadataModel, Model, ModelBuilder}

case class GrometFNModule(
  metadataOpt: Option[Int] = None, // GrometObject
  schemaOpt: Option[String] = Some("FN"),
  schemaVersionOpt: Option[String] = Some("0.1.4"),
  nameOpt: Option[String] = None,
  fnOpt: Option[GrometFN] = None,
  attributesOpt: Option[List[TypedValue]] = None,
  metadataCollectionOpt: Option[List[List[MetadataModel]]] = None,
) extends Model {
  import GrometFNModule._

  def toJson: JValue = {
    (METADATA -> metadataOpt) ~
    (SCHEMA -> schemaOpt) ~
    (SCHEMA_VERSION -> schemaVersionOpt) ~
    (NAME -> nameOpt) ~
    (FN -> fnOpt.map(_.toJson)) ~
    (ATTRIBUTES -> attributesOpt.map { attributes =>
      JArray(attributes.map(_.toJson))
    }) ~
    (METADATA_COLLECTION -> metadataCollectionOpt.map { metadataCollection =>
      JArray(metadataCollection.map { metadata =>
        JArray(metadata.map(_.toJson))
      })
    })
  }
}

object GrometFNModule extends ModelBuilder {
  val METADATA = "metadata"
  val SCHEMA = "schema"
  val SCHEMA_VERSION = "schema_version"
  val NAME = "name"
  val FN = "fn"
  val ATTRIBUTES = "attributes"
  val METADATA_COLLECTION = "metadata_collection"

  val METADATA_TYPE = "metadata_type"

  def fromJson(jValue: JValue): GrometFNModule = {
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
    val schemaOpt = (jValue \ SCHEMA).extractOpt[String]
    val schemaVersionOpt = (jValue \ SCHEMA_VERSION).extractOpt[String]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val fnOpt = (jValue \ FN).extractOpt[JValue].map(GrometFN.fromJson)
    val attributesOpt = (jValue \ ATTRIBUTES).extractOpt[JArray].map { jArray =>
      jArray.arr.map { jValue => TypedValue.fromJson(jValue) }
    }
    val metadataCollectionOpt = (jValue \ METADATA_COLLECTION).extractOpt[JArray].map { jArray =>
      jArray.arr.map { jValue =>
        jValue.extract[JArray].arr.map { jValue =>
          val metadataType = (jValue \ METADATA_TYPE).extract[String]

          metadataType match {
            case SourceCodeDataType.TYPE => SourceCodeDataType.fromJson(jValue)
            case EquationDefinition.TYPE => EquationDefinition.fromJson(jValue)
            case EquationParameter.TYPE => EquationParameter.fromJson(jValue)
            case GrometCreation.TYPE => GrometCreation.fromJson(jValue)
            case SourceCodeCollection.TYPE => SourceCodeCollection.fromJson(jValue)
            case SourceCodeLoopInit.TYPE => SourceCodeLoopInit.fromJson(jValue)
            case SourceCodeLoopUpdate.TYPE => SourceCodeLoopUpdate.fromJson(jValue)
            case SourceCodeReference.TYPE => SourceCodeReference.fromJson(jValue)
            case TextDefinition.TYPE => TextDefinition.fromJson(jValue)
            case TextParameter.TYPE => TextParameter.fromJson(jValue)
            case TextualDocumentCollection.TYPE => TextualDocumentCollection.fromJson(jValue)
            case _ => ???
          }
        }
      }
    }

    GrometFNModule(
      metadataOpt,
      schemaOpt,
      schemaVersionOpt,
      nameOpt,
      fnOpt,
      attributesOpt,
      metadataCollectionOpt
    )
  }
}
