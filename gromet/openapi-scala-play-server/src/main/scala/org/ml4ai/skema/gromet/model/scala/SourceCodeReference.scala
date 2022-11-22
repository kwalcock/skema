package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

import java.util.UUID

case class SourceCodeReference(
  metadataTypeOpt: Option[String] = None,
  codeFileReferenceUidOpt: Option[UUID] = None,
  lineBeginOpt: Option[Int] = None,
  lineEndOpt: Option[Int] = None,
  colBeginOpt: Option[Int] = None,
  colEndOpt: Option[Int] = None,
  provenanceOpt: Option[Provenance] = None
) extends Model {
  import SourceCodeReference._

  // TOTO UID

  def toJson: JValue = {
    (METADATA_TYPE -> metadataTypeOpt) ~
    (CODE_FILE_REFERENCE_UID -> codeFileReferenceUidOpt.map(_.toString)) ~
    (LINE_BEGIN -> lineBeginOpt) ~
    (LINE_END -> lineEndOpt) ~
    (COL_BEGIN -> colBeginOpt) ~
    (COL_END -> colEndOpt) ~
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object SourceCodeReference {
  implicit val formats: Formats = DefaultFormats

  val METADATA_TYPE = "metadataType"
  val CODE_FILE_REFERENCE_UID = "codeFileReferenceUid"
  val LINE_BEGIN = "lineBegin"
  val LINE_END = "lineEnd"
  val COL_BEGIN = "colBegin"
  val COL_END = "colEnd"
  val PROVENANCE = "provenance"

  def fromJson(jValue: JValue): SourceCodeReference = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val codeFileReferenceUidOpt = (jValue \ CODE_FILE_REFERENCE_UID).extractOpt[String].asInstanceOf[Option[UUID]]
    val lineBeginOpt = (jValue \ LINE_BEGIN).extractOpt[Int]
    val lineEndOpt = (jValue \ LINE_END).extractOpt[Int]
    val colBeginOpt = (jValue \ COL_BEGIN).extractOpt[Int]
    val colEndOpt = (jValue \ COL_END).extractOpt[Int]
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    SourceCodeReference(
      metadataTypeOpt,
      codeFileReferenceUidOpt,
      lineBeginOpt,
      lineEndOpt,
      colBeginOpt,
      colEndOpt,
      provenanceOpt
    )
  }
}
