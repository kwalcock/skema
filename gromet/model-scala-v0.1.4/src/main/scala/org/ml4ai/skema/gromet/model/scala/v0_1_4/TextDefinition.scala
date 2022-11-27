package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.TextDefinition._

case class TextDefinition(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some(TYPE),
  textExtractionOpt: Option[TextExtraction] = None,
  variableIdentifierOpt: Option[String] = None,
  variableDefinitionOpt: Option[String] = None
) extends Model {

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (TEXT_EXTRACTION -> textExtractionOpt.map(_.toJson)) ~
    (VARIABLE_IDENTIFIER -> variableIdentifierOpt) ~
    (VARIABLE_DEFINITION -> variableDefinitionOpt)
  }
}

object TextDefinition extends ModelBuilder {
  val TYPE = "text_definition"

  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val TEXT_EXTRACTION = "text_extraction"
  val VARIABLE_IDENTIFIER = "variable_identifier"
  val VARIABLE_DEFINITION = "variable_definition"

  def fromJson(jValue: JValue): TextDefinition = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val textExtractionOpt = (jValue \ TEXT_EXTRACTION).extractOpt[JValue].map(TextExtraction.fromJson)
    val variableIdentifierOpt = (jValue \ VARIABLE_IDENTIFIER).extractOpt[String]
    val variableDefinitionOpt = (jValue \ VARIABLE_DEFINITION).extractOpt[String]

    TextDefinition(
      provenanceOpt,
      metadataTypeOpt,
      textExtractionOpt,
      variableIdentifierOpt,
      variableDefinitionOpt
    )
  }
}
