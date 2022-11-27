package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JsonDSL._
import org.json4s.{JArray, JValue}
import org.ml4ai.skema.gromet.model.scala.v0_1_4.SourceCodeCollection._

case class SourceCodeCollection(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some(TYPE),
  nameOpt: Option[String] = None,
  globalReferenceIdOpt: Option[String] = None,
  filesOpt: Option[List[CodeFileReference]] = None
) extends Model {

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (NAME -> nameOpt) ~
    (GLOBAL_REFERENCE_ID -> globalReferenceIdOpt) ~
    (FILES -> filesOpt.map(value => JArray(value.map(_.toJson))))
  }
}

object SourceCodeCollection extends ModelBuilder {
  val TYPE = "source_code_collection"

  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val NAME = "name"
  val GLOBAL_REFERENCE_ID = "global_reference_id"
  val FILES = "files"

  def fromJson(jValue: JValue): SourceCodeCollection = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val globalReferenceIdOpt = (jValue \ GLOBAL_REFERENCE_ID).extractOpt[String]
    val filesOpt = (jValue \ FILES).extractOpt[JArray].map(_.arr.map(CodeFileReference.fromJson))

    SourceCodeCollection(
      provenanceOpt,
      metadataTypeOpt,
      nameOpt,
      globalReferenceIdOpt,
      filesOpt
    )
  }
}
