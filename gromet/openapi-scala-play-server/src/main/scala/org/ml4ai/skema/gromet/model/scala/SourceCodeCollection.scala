package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JArray, JValue}
import org.json4s.JsonDSL._

case class SourceCodeCollection(
  metadataTypeOpt: Option[String] = None,
  nameOpt: Option[String] = None,
  globalReferenceIdOpt: Option[String] = None,
  filesOpt: Option[List[CodeFileReference]] = None,
  provenanceOpt: Option[Provenance] = None
) extends Model {
  import SourceCodeCollection._

  def toJson: JValue = {
    (METADATA_TYPE -> metadataTypeOpt) ~
    (NAME -> nameOpt) ~
    (GLOBAL_REFERENCE_ID -> globalReferenceIdOpt) ~
    (FILES -> filesOpt) ~ // This is a list
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object SourceCodeCollection {
  implicit val formats: Formats = DefaultFormats

  val METADATA_TYPE = "metadataType"
  val NAME = "name"
  val GLOBAL_REFERENCE_ID = "globalReferenceId"
  val FILES = "files"
  val PROVENANCE = "provenance"

  def fromJson(jValue: JValue): SourceCodeCollection = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val globalReferenceIdOpt = (jValue \ GLOBAL_REFERENCE_ID).extractOpt[Int]
    val filesOpt = (jValue \ FILES).extractOpt[JArray].map(CodeFileReference.fromJson)
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    SourceCodeCollection(
      metadataTypeOpt,
      nameOpt,
      globalReferenceIdOpt,
      filesOpt,
      provenanceOpt
    )
  }
}
