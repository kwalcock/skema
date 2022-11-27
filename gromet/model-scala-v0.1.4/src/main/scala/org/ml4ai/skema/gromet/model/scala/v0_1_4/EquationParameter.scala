package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{MetadataModel, MetadataModelBuilder}

case class EquationParameter(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some(EquationParameter.TYPE),
  equationExtractionOpt: Option[EquationExtraction] = None,
  variableIdentifierOpt: Option[String] = None,
  valueOpt: Option[LiteralValue] = None,
) extends MetadataModel {
  import EquationParameter._

  def provenance: Provenance = provenanceOpt.get
  def metadataType: String = metadataTypeOpt.get
  def equationExtraction: EquationExtraction = equationExtractionOpt.get
  def variableIdentifier: String = variableIdentifierOpt.get
  def value: LiteralValue = valueOpt.get

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (EQUATION_EXTRACTION -> equationExtractionOpt.map(_.toJson)) ~
    (VARIABLE_IDENTIFIER -> variableIdentifierOpt) ~
    (VALUE -> valueOpt.map(_.toJson))
  }
}

object EquationParameter extends MetadataModelBuilder {
  val TYPE = "equation_parameter"

  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val EQUATION_EXTRACTION = "equation_extraction"
  val VARIABLE_IDENTIFIER = "variable_identifier"
  val VALUE = "value"

  def fromJson(jValue: JValue): EquationParameter = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val equationExtractionOpt = (jValue \ EQUATION_EXTRACTION).extractOpt[JValue].map(EquationExtraction.fromJson)
    val variableIdentifierOpt = (jValue \ VARIABLE_IDENTIFIER).extractOpt[String]
    val valueOpt = (jValue \ VALUE).extractOpt[JValue].map(LiteralValue.fromJson)

    EquationParameter(
      provenanceOpt,
      metadataTypeOpt,
      equationExtractionOpt,
      variableIdentifierOpt,
      valueOpt
    )
  }
}
