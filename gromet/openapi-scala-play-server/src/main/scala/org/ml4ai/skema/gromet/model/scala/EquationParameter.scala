package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class EquationParameter(
  metadataTypeOpt: Option[String],
  equationExtractionOpt: Option[EquationExtraction],
  variableIdentifierOpt: Option[String],
  valueOpt: Option[LiteralValue],
  provenanceOpt: Option[Provenance]
) extends Model {
  import EquationParameter._

  def metadataType: String = metadataTypeOpt.get
  def equationExtraction: EquationExtraction = equationExtractionOpt.get
  def variableIdentifier: String = variableIdentifierOpt.get
  def value: LiteralValue = valueOpt.get
  def provenance: Provenance = provenanceOpt.get

  def toJson: JValue = {
    (METADATA_TYPE -> metadataTypeOpt) ~
    (EQUATION_EXTRACTION -> equationExtractionOpt.map(_.toJson)) ~
    (VARIABLE_IDENTIFIER -> variableIdentifierOpt) ~
    (VALUE -> valueOpt.map(_.toJson)) ~
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object EquationParameter {
  implicit val formats: Formats = DefaultFormats

  val METADATA_TYPE = "metadataType"
  val EQUATION_EXTRACTION = "equationExtraction"
  val VARIABLE_IDENTIFIER = "variableIdentifier"
  val VALUE = "value"
  val PROVENANCE = "provenance"

  // TODO, also add Option[String] to list
  // It needs everything
  // TODO: Each object also inherits from a class and has getMapping
  // But first complete this to see if it works.
  // Some things are ObjectSerializers, ArraySerializers, LiteralSerializers
  // EnumeratorSerialisers as base class
  // The case class objects get a constructor based on the result of the serializer, a map or array or whatnot

  def fromJson(jValue: JValue): EquationParameter = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val equationExtractionOpt = (jValue \ EQUATION_EXTRACTION).extractOpt[JValue].map(EquationExtraction.fromJson)
    val variableIdentifierOpt = (jValue \ VARIABLE_IDENTIFIER).extractOpt[String]
    val valueOpt = (jValue \ VALUE).extractOpt[JValue].map(LiteralValue.fromJson)
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    EquationParameter(
      metadataTypeOpt,
      equationExtractionOpt,
      variableIdentifierOpt,
      valueOpt,
      provenanceOpt
    )
  }
}
