package org.ml4ai.skema.gromet.model.scala

import org.json4s.JValue
import org.json4s.JsonDSL._

import java.util.UUID

case class SourceCodeReference(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some("source_code_reference"),
  codeFileReferenceUidOpt: Option[UUID] = None,
  lineBeginOpt: Option[Int] = None,
  lineEndOpt: Option[Int] = None,
  colBeginOpt: Option[Int] = None,
  colEndOpt: Option[Int] = None
) extends Model {
  import SourceCodeReference._

  // TODO UID

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (CODE_FILE_REFERENCE_UID -> codeFileReferenceUidOpt.map(_.toString)) ~
    (LINE_BEGIN -> lineBeginOpt) ~
    (LINE_END -> lineEndOpt) ~
    (COL_BEGIN -> colBeginOpt) ~
    (COL_END -> colEndOpt)
  }
}

object SourceCodeReference extends ModelBuilder {
  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val CODE_FILE_REFERENCE_UID = "code_file_reference_uid"
  val LINE_BEGIN = "line_begin"
  val LINE_END = "line_end"
  val COL_BEGIN = "col_begin"
  val COL_END = "col_end"

  def fromJson(jValue: JValue): SourceCodeReference = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val codeFileReferenceUidOpt = (jValue \ CODE_FILE_REFERENCE_UID).extractOpt[String].asInstanceOf[Option[UUID]]
    val lineBeginOpt = (jValue \ LINE_BEGIN).extractOpt[Int]
    val lineEndOpt = (jValue \ LINE_END).extractOpt[Int]
    val colBeginOpt = (jValue \ COL_BEGIN).extractOpt[Int]
    val colEndOpt = (jValue \ COL_END).extractOpt[Int]

    SourceCodeReference(
      provenanceOpt,
      metadataTypeOpt,
      codeFileReferenceUidOpt,
      lineBeginOpt,
      lineEndOpt,
      colBeginOpt,
      colEndOpt
    )
  }
}
