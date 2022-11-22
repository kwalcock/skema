package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class SourceCodeDataType(
  metadataTypeOpt: Option[String] = None,
  sourceLanguageOpt: Option[String] = None,
  sourceLanguageVersionOpt: Option[String] = None,
  dataTypeOpt: Option[String] = None,
  provenanceOpt: Option[Provenance] = None
) extends Model {
  import SourceCodeDataType._

  def toJson: JValue = {
    (METADATA_TYPE -> metadataTypeOpt) ~
    (SOURCE_LANGUAGE -> sourceLanguageOpt) ~
    (SOURCE_LANGUAGE_VERSION -> sourceLanguageVersionOpt) ~
    (DATA_TYPE -> dataTypeOpt) ~
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object SourceCodeDataType {
  implicit val formats: Formats = DefaultFormats

  val METADATA_TYPE = "metadataType"
  val SOURCE_LANGUAGE = "sourceLangauge"
  val SOURCE_LANGUAGE_VERSION = "sourceLanguageVersion"
  val DATA_TYPE = "dataType"
  val PROVENANCE = "provenance"

  def fromJson(jValue: JValue): SourceCodeDataType = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val sourceLanguageOpt = (jValue \ SOURCE_LANGUAGE).extractOpt[String]
    val sourceLanguageVersionOpt = (jValue \ SOURCE_LANGUAGE_VERSION).extractOpt[String]
    val dataTypeOpt = (jValue \ DATA_TYPE).extractOpt[String]
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    SourceCodeDataType(
      metadataTypeOpt,
      sourceLanguageOpt,
      sourceLanguageVersionOpt,
      dataTypeOpt,
      provenanceOpt
    )
  }
}
