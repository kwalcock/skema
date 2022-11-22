package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class EquationDefinition(
  metadataTypeOpt: Option[String] = None,
  equationExtractionOpt: Option[EquationExtraction] = None,
  equationMathmlSourceOpt: Option[String] = None,
  equationLatexSourceOpt: Option[String] = None,
  provenanceOpt: Option[Provenance] = None
) extends Model {
  import EquationDefinition._

  def metadataType: String = metadataTypeOpt.get
  def equationExtraction: EquationExtraction = equationExtractionOpt.get
  def equationMathmlSource: String = equationMathmlSourceOpt.get
  def equationLatexSource: String = equationLatexSourceOpt.get
  def provenance: Provenance = provenanceOpt.get

  def toJson: JValue = {
    (METADATA_TYPE -> metadataTypeOpt) ~
    (EQUATION_EXTRACTION -> equationExtractionOpt.map(_.toJson)) ~
    (EQUATION_MATHML_SOURCE -> equationMathmlSourceOpt) ~
    (EQUATION_LATEX_SOURCE -> equationLatexSourceOpt) ~
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object EquationDefinition {
  implicit val formats: Formats = DefaultFormats

  val METADATA_TYPE = "metadataType"
  val EQUATION_EXTRACTION = "equationExtraction"
  val EQUATION_MATHML_SOURCE = "equationMathmlSource"
  val EQUATION_LATEX_SOURCE = "equationLatexSource"
  val PROVENANCE = "provenance"

  def fromJson(jValue: JValue): EquationDefinition = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val equationExtractionOpt = (jValue \ EQUATION_EXTRACTION).extractOpt[JValue].map(EquationExtraction.fromJson)
    val equationMathmlSourceOpt = (jValue \ EQUATION_MATHML_SOURCE).extractOpt[String]
    val equationLatexSourceOpt = (jValue \ EQUATION_LATEX_SOURCE).extractOpt[String]
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    EquationDefinition(
      metadataTypeOpt,
      equationExtractionOpt,
      equationMathmlSourceOpt,
      equationLatexSourceOpt,
      provenanceOpt
    )
  }
}

