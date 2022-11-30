package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{MetadataModel, MetadataModelBuilder}

case class TextDefinition(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some(TextDefinition.TYPE),
  textExtractionOpt: Option[TextExtraction] = None,
  variableIdentifierOpt: Option[String] = None,
  variableDefinitionOpt: Option[String] = None
) extends MetadataModel {
  import TextDefinition._

  def provenance: Provenance = provenanceOpt.get
  def metadataType: String = metadataTypeOpt.get
  def textExtraction: TextExtraction = textExtractionOpt.get
  def variableIdentifier: String = variableIdentifierOpt.get
  def variableDefinition: String = variableDefinitionOpt.get

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (TEXT_EXTRACTION -> textExtractionOpt.map(_.toJson)) ~
    (VARIABLE_IDENTIFIER -> variableIdentifierOpt) ~
    (VARIABLE_DEFINITION -> variableDefinitionOpt)
  }
}

object TextDefinition extends MetadataModelBuilder {
  val TYPE = "text_definition"

  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val TEXT_EXTRACTION = "text_extraction"
  val VARIABLE_IDENTIFIER = "variable_identifier"
  val VARIABLE_DEFINITION = "variable_definition"

  override val keys = Set(
    PROVENANCE,
    METADATA_TYPE,
    TEXT_EXTRACTION,
    VARIABLE_IDENTIFIER,
    VARIABLE_DEFINITION
  )

  def fromJson(jValue: JValue): TextDefinition = {
    checkKeys(jValue)

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
