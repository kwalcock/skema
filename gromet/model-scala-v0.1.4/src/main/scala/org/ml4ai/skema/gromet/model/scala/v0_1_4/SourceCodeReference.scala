package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.SourceCodeReference._

case class SourceCodeReference(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some(TYPE),
  codeFileReferenceUidOpt: Option[String /*UUID*/] = None,
  lineBeginOpt: Option[Int] = None,
  lineEndOpt: Option[Int] = None,
  colBeginOpt: Option[Int] = None,
  colEndOpt: Option[Int] = None
) extends Model {

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (CODE_FILE_REFERENCE_UID -> codeFileReferenceUidOpt) ~ // .map(toJson)) ~
    (LINE_BEGIN -> lineBeginOpt) ~
    (LINE_END -> lineEndOpt) ~
    (COL_BEGIN -> colBeginOpt) ~
    (COL_END -> colEndOpt)
  }
}

object SourceCodeReference extends ModelBuilder {
  val TYPE = "source_code_reference"

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
    val codeFileReferenceUidOpt = (jValue \ CODE_FILE_REFERENCE_UID).extractOpt[String] // JString].map(uuidFromJson)
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
