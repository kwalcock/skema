package org.ml4ai.skema.gromet.model.scala

import org.json4s.JValue
import org.json4s.JsonDSL._

case class EquationExtraction(
  sourceTypeOpt: Option[String] = Some("equation_document_source"),
  documentReferenceUidOpt: Option[String] = None,
  equationNumberOpt: Option[Int] = None
) extends Model {
  import EquationExtraction._

  def sourceType: String = sourceTypeOpt.get
  def documentReferenceUid: String = documentReferenceUidOpt.get
  def equationNumber: Int = equationNumberOpt.get

  def toJson: JValue = {
    (SOURCE_TYPE -> sourceTypeOpt) ~
    (DOCUMENT_REFERENCE_UID -> documentReferenceUidOpt) ~
    (EQUATION_NUMBER -> equationNumberOpt)
  }
}

object EquationExtraction extends ModelBuilder {
  val SOURCE_TYPE = "source_type"
  val DOCUMENT_REFERENCE_UID = "document_reference_uid"
  val EQUATION_NUMBER = "equation_number"

  def fromJson(jValue: JValue): EquationExtraction = {
    val sourceTypeOpt = (jValue \ SOURCE_TYPE).extractOpt[String]
    val documentReferenceUidOpt = (jValue \ DOCUMENT_REFERENCE_UID).extractOpt[String]
    val equationNumberOpt = (jValue \ EQUATION_NUMBER).extractOpt[Int]

    EquationExtraction(
      sourceTypeOpt,
      documentReferenceUidOpt,
      equationNumberOpt
    )
  }
}