package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class TextDefinition(
  metadataTypeOpt: Option[String] = None,
  textExtractionOpt: Option[TextExtraction] = None,
  variableIdentifierOpt: Option[String] = None,
  variableDefinitionOpt: Option[String] = None,
  provenanceOpt: Option[Provenance] = None
) extends Model {
  import TextDefinition._

  def toJson: JValue = {
    (METADATA_TYPE -> metadataTypeOpt) ~
    (TEXT_EXTRACTION -> textExtractionOpt.map(_.toJson)) ~
    (VARIABLE_IDENTIFIER -> variableIdentifierOpt) ~
    (VARIABLE_DEFINITION -> variableDefinitionOpt) ~
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object TextDefinition {
  implicit val formats: Formats = DefaultFormats

  val METADATA_TYPE = "metadataType"
  val TEXT_EXTRACTION = "textExtraction"
  val VARIABLE_IDENTIFIER = "variableIdentifier"
  val VARIABLE_DEFINITION = "variableDefinition"
  val PROVENANCE = "provenance"

  def fromJson(jValue: JValue): TextDefinition = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val textExtractionOpt = (jValue \ TEXT_EXTRACTION).extractOpt[JValue].map(TextExtraction.fromJson)
    val variableIdentifierOpt = (jValue \ VARIABLE_IDENTIFIER).extractOpt[String]
    val variableDefinitionOpt = (jValue \ VARIABLE_DEFINITION).extractOpt[String]
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    TextDefinition(
      metadataTypeOpt,
      textExtractionOpt,
      variableIdentifierOpt,
      variableDefinitionOpt,
      provenanceOpt
    )
  }
}
