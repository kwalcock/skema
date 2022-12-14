package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{MetadataModel, MetadataModelBuilder}

case class EquationDefinition(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some(EquationDefinition.TYPE),
  equationExtractionOpt: Option[EquationExtraction] = None,
  equationMathmlSourceOpt: Option[String] = None,
  equationLatexSourceOpt: Option[String] = None
) extends MetadataModel {
  import EquationDefinition._

  def provenance: Provenance = provenanceOpt.get
  def metadataType: String = metadataTypeOpt.get
  def equationExtraction: EquationExtraction = equationExtractionOpt.get
  def equationMathmlSource: String = equationMathmlSourceOpt.get
  def equationLatexSource: String = equationLatexSourceOpt.get

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (EQUATION_EXTRACTION -> equationExtractionOpt.map(_.toJson)) ~
    (EQUATION_MATHML_SOURCE -> equationMathmlSourceOpt) ~
    (EQUATION_LATEX_SOURCE -> equationLatexSourceOpt)
  }
}

object EquationDefinition extends MetadataModelBuilder {
  val TYPE = "equation_definition"

  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val EQUATION_EXTRACTION = "equation_extraction"
  val EQUATION_MATHML_SOURCE = "equation_mathml_source"
  val EQUATION_LATEX_SOURCE = "equation_latex_source"

  override val keys = Set(
    PROVENANCE,
    METADATA_TYPE,
    EQUATION_EXTRACTION,
    EQUATION_MATHML_SOURCE,
    EQUATION_LATEX_SOURCE
  )

  def fromJson(jValue: JValue): EquationDefinition = {
    checkKeys(jValue)

    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val equationExtractionOpt = (jValue \ EQUATION_EXTRACTION).extractOpt[JValue].map(EquationExtraction.fromJson)
    val equationMathmlSourceOpt = (jValue \ EQUATION_MATHML_SOURCE).extractOpt[String]
    val equationLatexSourceOpt = (jValue \ EQUATION_LATEX_SOURCE).extractOpt[String]

    EquationDefinition(
      provenanceOpt,
      metadataTypeOpt,
      equationExtractionOpt,
      equationMathmlSourceOpt,
      equationLatexSourceOpt
    )
  }
}

