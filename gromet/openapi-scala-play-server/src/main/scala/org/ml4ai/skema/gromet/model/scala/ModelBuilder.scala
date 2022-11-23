package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}

import java.util.Date

abstract class ModelBuilder {
  import ModelBuilder._
  implicit val formats: Formats = DefaultFormats

  def fromJson(jValue: JValue): Model

  def dateFromJson(json: JValue): Date = null // TODO
}

object ModelBuilder {
  val METADATA_TYPE = "metadata_type"
  val PROVENANCE = "provenance"
}
