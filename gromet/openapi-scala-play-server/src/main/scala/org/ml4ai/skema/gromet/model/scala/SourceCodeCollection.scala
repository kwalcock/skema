package org.ml4ai.skema.gromet.model.scala

import org.json4s.{JArray, JValue}
import org.json4s.JsonDSL._

case class SourceCodeCollection(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some("source_code_collection"),
  nameOpt: Option[String] = None,
  globalReferenceIdOpt: Option[String] = None,
  filesOpt: Option[List[CodeFileReference]] = None
) extends Model {
  import SourceCodeCollection._

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (NAME -> nameOpt) ~
    (GLOBAL_REFERENCE_ID -> globalReferenceIdOpt) ~
    (FILES -> filesOpt.map(value => JArray(value.map(_.toJson))))
  }
}

object SourceCodeCollection extends ModelBuilder {
  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val NAME = "name"
  val GLOBAL_REFERENCE_ID = "global_reference_id"
  val FILES = "files"

  def fromJson(jValue: JValue): SourceCodeCollection = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val globalReferenceIdOpt = (jValue \ GLOBAL_REFERENCE_ID).extractOpt[String]
    val filesOpt = (jValue \ FILES).extractOpt[JArray].map(_.arr.map(CodeFileReference.fromJson))

    SourceCodeCollection(
      provenanceOpt,
      metadataTypeOpt,
      nameOpt,
      globalReferenceIdOpt,
      filesOpt
    )
  }
}
