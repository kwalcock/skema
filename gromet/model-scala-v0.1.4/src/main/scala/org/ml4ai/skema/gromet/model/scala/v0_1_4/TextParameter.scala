package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{MetadataModel, MetadataModelBuilder}

case class TextParameter(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some(TextParameter.TYPE),
  textExtractionOpt: Option[TextExtraction] = None,
  variableIdentifierOpt: Option[String] = None,
  valueOpt: Option[LiteralValue] = None
) extends MetadataModel {
  import TextParameter._

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson))
    (METADATA_TYPE -> metadataTypeOpt) ~
    (TEXT_EXTRACTION -> textExtractionOpt.map(_.toJson)) ~
    (VARIABLE_IDENTIFIER -> variableIdentifierOpt) ~
    (VALUE -> valueOpt.map(_.toJson))
  }
}

object TextParameter extends MetadataModelBuilder {
  val TYPE = "text_parameter"

  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val TEXT_EXTRACTION = "text_xtraction"
  val VARIABLE_IDENTIFIER = "variable_identifier"
  val VALUE = "value"

  def fromJson(jValue: JValue): TextParameter = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val textExtractionOpt = (jValue \ TEXT_EXTRACTION).extractOpt[JValue].map(TextExtraction.fromJson)
    val variableIdentifierOpt = (jValue \ VARIABLE_IDENTIFIER).extractOpt[String]
    val valueOpt = (jValue \ VALUE).extractOpt[JValue].map(LiteralValue.fromJson)

    TextParameter(
      provenanceOpt,
      metadataTypeOpt,
      textExtractionOpt,
      variableIdentifierOpt,
      valueOpt
    )
  }
}
