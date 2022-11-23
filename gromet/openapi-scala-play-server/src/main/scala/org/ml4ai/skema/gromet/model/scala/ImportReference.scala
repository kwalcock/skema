package org.ml4ai.skema.gromet.model.scala

import org.json4s.JValue
import org.json4s.JsonDSL._

case class ImportReference(
  nameOpt: Option[String] = None,
  srcLanguageOpt: Option[String] = None,
  typeOpt: Option[ImportType] = None,
  versionOpt: Option[String] = None,
  uriOpt: Option[TypedValue] = None
) extends Model {
  import ImportReference._

  def toJson: JValue = {
    (NAME -> nameOpt) ~
    (SRC_LANGUAGE -> srcLanguageOpt) ~
    (TYPE -> typeOpt.map(_.toJson)) ~
    (VERSION -> versionOpt) ~
    (URI -> uriOpt.map(_.toJson))
  }
}

object ImportReference extends ModelBuilder {
  val NAME = "name"
  val SRC_LANGUAGE = "src_language"
  val TYPE = "type"
  val VERSION = "version"
  val URI = "uri"

  def fromJson(jValue: JValue): ImportReference = {
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val srcLanguageOpt = (jValue \ SRC_LANGUAGE).extractOpt[String]
    val typeOpt = (jValue \ TYPE).extractOpt[JValue].map(ImportType.fromJson)
    val versionOpt = (jValue \ VERSION).extractOpt[String]
    val uriOpt = (jValue \ URI).extractOpt[JValue].map(TypedValue.fromJson)

    ImportReference(
      nameOpt,
      srcLanguageOpt,
      typeOpt,
      versionOpt,
      uriOpt
    )
  }
}
