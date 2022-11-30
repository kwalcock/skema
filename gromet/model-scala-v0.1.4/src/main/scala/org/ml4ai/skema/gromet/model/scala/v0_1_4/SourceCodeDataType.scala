package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{MetadataModel, MetadataModelBuilder}

case class SourceCodeDataType(
  provenanceOpt: Option[Provenance] = None, // Metadata
  metadataTypeOpt: Option[String] = Some(SourceCodeDataType.TYPE),
  sourceLanguageOpt: Option[String] = None,
  sourceLanguageVersionOpt: Option[String] = None,
  dataTypeOpt: Option[String] = None,
) extends MetadataModel {
  import SourceCodeDataType._

  def provenance: Provenance = provenanceOpt.get
  def metadataType: String = metadataTypeOpt.get
  def sourceLanguage: String = sourceLanguageOpt.get
  def sourceLanguageVersion: String = sourceLanguageVersionOpt.get
  def dataType: String = dataTypeOpt.get

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (SOURCE_LANGUAGE -> sourceLanguageOpt) ~
    (SOURCE_LANGUAGE_VERSION -> sourceLanguageVersionOpt) ~
    (DATA_TYPE -> dataTypeOpt)
  }
}

object SourceCodeDataType extends MetadataModelBuilder {
  val TYPE = "source_code_data_type"

  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val SOURCE_LANGUAGE = "source_language"
  val SOURCE_LANGUAGE_VERSION = "source_language_version"
  val DATA_TYPE = "data_type"

  override val keys = Set(
    PROVENANCE,
    METADATA_TYPE,
    SOURCE_LANGUAGE,
    SOURCE_LANGUAGE_VERSION,
    DATA_TYPE
  )

  def fromJson(jValue: JValue): SourceCodeDataType = {
    checkKeys(jValue)

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
