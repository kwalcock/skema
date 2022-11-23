package org.ml4ai.skema.gromet.model.scala

import org.json4s.JValue
import org.json4s.JsonDSL._

case class SourceCodeDataType(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some("source_code_data_type"),
  sourceLanguageOpt: Option[String] = None,
  sourceLanguageVersionOpt: Option[String] = None,
  dataTypeOpt: Option[String] = None,
) extends Model {
  import SourceCodeDataType._

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson))
    (METADATA_TYPE -> metadataTypeOpt) ~
    (SOURCE_LANGUAGE -> sourceLanguageOpt) ~
    (SOURCE_LANGUAGE_VERSION -> sourceLanguageVersionOpt) ~
    (DATA_TYPE -> dataTypeOpt)
  }
}

object SourceCodeDataType extends ModelBuilder {
  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val SOURCE_LANGUAGE = "source_langauge"
  val SOURCE_LANGUAGE_VERSION = "source_language_version"
  val DATA_TYPE = "data_type"

  def fromJson(jValue: JValue): SourceCodeDataType = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val sourceLanguageOpt = (jValue \ SOURCE_LANGUAGE).extractOpt[String]
    val sourceLanguageVersionOpt = (jValue \ SOURCE_LANGUAGE_VERSION).extractOpt[String]
    val dataTypeOpt = (jValue \ DATA_TYPE).extractOpt[String]

    SourceCodeDataType(
      provenanceOpt,
      metadataTypeOpt,
      sourceLanguageOpt,
      sourceLanguageVersionOpt,
      dataTypeOpt
    )
  }
}
