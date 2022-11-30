package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{MetadataModel, MetadataModelBuilder}

case class SourceCodeLoopInit(
  provenanceOpt: Option[Provenance], // Metadata
  metadataTypeOpt: Option[String] = Some(SourceCodeLoopInit.TYPE),
  sourceLanguageOpt: Option[String] = None,
  sourceLanguageVersionOpt: Option[String] = None,
  loopNameOpt: Option[String] = None
) extends MetadataModel {
  import SourceCodeLoopInit._

  def provenance: Provenance = provenanceOpt.get
  def metadataType: String = metadataTypeOpt.get
  def sourceLanguage: String = sourceLanguageOpt.get
  def sourceLanguageVersion: String = sourceLanguageVersionOpt.get
  def loopName: String = loopNameOpt.get

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson)) ~
    (METADATA_TYPE -> metadataTypeOpt) ~
    (SOURCE_LANGUAGE -> sourceLanguageOpt) ~
    (SOURCE_LANGUAGE_VERSION -> sourceLanguageVersionOpt) ~
    (LOOP_NAME -> loopNameOpt)
  }
}

object SourceCodeLoopInit extends MetadataModelBuilder {
  val TYPE = "source_code_loop_init"

  val PROVENANCE = "provenance"
  val METADATA_TYPE = "metadata_type"
  val SOURCE_LANGUAGE = "source_language"
  val SOURCE_LANGUAGE_VERSION = "source_language_version"
  val LOOP_NAME = "loop_name"

  def fromJson(jValue: JValue): SourceCodeLoopInit = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val sourceLanguageOpt = (jValue \ SOURCE_LANGUAGE).extractOpt[String]
    val sourceLanguageVersionOpt = (jValue \ SOURCE_LANGUAGE_VERSION).extractOpt[String]
    val loopNameOpt = (jValue \ LOOP_NAME). extractOpt[String]

    SourceCodeLoopInit(
      provenanceOpt,
      metadataTypeOpt,
      sourceLanguageOpt,
      sourceLanguageVersionOpt,
      loopNameOpt
    )
  }
}
