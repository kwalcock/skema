package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class TextExtraction(
  documentReferenceUidOpt: Option[String] = None,
  pageOpt: Option[Int] = None,
  blockOpt: Option[Int] = None,
  charBeginOpt: Option[Int] = None,
  charEndOpt: Option[Int] = None
) extends Model {
  import TextExtraction._

  def toJson: JValue = {
    (DOCUMENT_REFERENCE_UID -> documentReferenceUidOpt) ~
    (PAGE -> pageOpt) ~
    (BLOCK -> blockOpt) ~
    (CHAR_BEGIN -> charBeginOpt) ~
    (CHAR_END -> charEndOpt)
  }
}

object TextExtraction extends ModelBuilder {
  val DOCUMENT_REFERENCE_UID = "document_reference_uid"
  val PAGE = "age"
  val BLOCK = "block"
  val CHAR_BEGIN = "char_begin"
  val CHAR_END = "char_end"

  def fromJson(jValue: JValue): TextExtraction = {
    val documentReferenceUidOpt = (jValue \ DOCUMENT_REFERENCE_UID).extractOpt[String]
    val pageOpt = (jValue \ PAGE).extractOpt[Int]
    val blockOpt = (jValue \ BLOCK).extractOpt[Int]
    val charBeginOpt = (jValue \ CHAR_BEGIN).extractOpt[Int]
    val charEndOpt = (jValue \ CHAR_END).extractOpt[Int]

    TextExtraction(
      documentReferenceUidOpt,
      pageOpt,
      blockOpt,
      charBeginOpt,
      charEndOpt
    )
  }
}

