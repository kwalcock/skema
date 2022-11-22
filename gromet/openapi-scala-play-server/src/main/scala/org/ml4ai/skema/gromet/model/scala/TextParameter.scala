package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class TextParameter(
  metadataTypeOpt: Option[String] = None,
  textExtractionOpt: Option[TextExtraction] = None,
  variableIdentifierOpt: Option[String] = None,
  valueOpt: Option[LiteralValue] = None,
  provenanceOpt: Option[Provenance] = None
) extends Model {
  import TextParameter._

  def toJson: JValue = {
    (METADATA_TYPE -> metadataTypeOpt) ~
    (TEXT_EXTRACTION -> textExtractionOpt.map(_.toJson)) ~
    (VARIABLE_IDENTIFIER -> variableIdentifierOpt) ~
    (VALUE -> valueOpt.map(_.toJson)) ~
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object TextParameter {
  implicit val formats: Formats = DefaultFormats

  val METADATA_TYPE = "metadataType"
  val TEXT_EXTRACTION = "textExtraction"
  val VARIABLE_IDENTIFIER = "variableIdentifier"
  val VALUE = "value"
  val PROVENANCE = "provenance"

  def fromJson(jValue: JValue): TextParameter = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val textExtractionOpt = (jValue \ TEXT_EXTRACTION).extractOpt[JValue].map(TextExtraction.fromJson)
    val variableIdentifierOpt = (jValue \ VARIABLE_IDENTIFIER).extractOpt[String]
    val valueOpt = (jValue \ VALUE).extractOpt[JValue].map(LiteralValue.fromJson)
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    TextParameter(
      metadataTypeOpt,
      textExtractionOpt,
      variableIdentifierOpt,
      valueOpt,
      provenanceOpt
    )
  }
}
