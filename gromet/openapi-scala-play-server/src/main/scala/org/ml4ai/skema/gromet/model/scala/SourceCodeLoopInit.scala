package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class SourceCodeLoopInit(
  metadataTypeOpt: Option[String] = None,
  sourceLanguageOpt: Option[String] = None,
  sourceLanguageVersionOpt: Option[String] = None,
  loopNameOpt: Option[String] = None,
  provenanceOpt: Option[Provenance]
) extends Model {
  import SourceCodeLoopInit._

  def toJson: JValue = {
    (METADATA_TYPE -> metadataTypeOpt) ~
    (SOURCE_LANGUAGE -> sourceLanguageOpt) ~
    (SOURCE_LANGUAGE_VERSION -> sourceLanguageVersionOpt) ~
    (LOOP_NAME -> loopNameOpt) ~
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object SourceCodeLoopInit {
  implicit val formats: Formats = DefaultFormats

  val METADATA_TYPE = "metadataType"
  val SOURCE_LANGUAGE = "sourceLanguage"
  val SOURCE_LANGUAGE_VERSION = "sourceLanguageVersion"
  val LOOP_NAME = "loopName"
  val PROVENANCE = "provenance"

  def fromJson(jValue: JValue): SourceCodeLoopInit = {
    val metadataTypeOpt = (jValue \ METADATA_TYPE).extractOpt[String]
    val sourceLanguageOpt = (jValue \ SOURCE_LANGUAGE).extractOpt[String]
    val sourceLanguageVersionOpt = (jValue \ SOURCE_LANGUAGE_VERSION).extractOpt[String]
    val loopNameOpt = (jValue \ LOOP_NAME). extractOpt[String]
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    SourceCodeLoopInit(
      metadataTypeOpt,
      sourceLanguageOpt,
      sourceLanguageVersionOpt,
      loopNameOpt,
      provenanceOpt
    )
  }
}
