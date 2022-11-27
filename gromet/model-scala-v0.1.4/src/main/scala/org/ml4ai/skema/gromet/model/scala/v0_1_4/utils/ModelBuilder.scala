package org.ml4ai.skema.gromet.model.scala.v0_1_4.utils

import org.json4s.{DefaultFormats, Formats, JString, JValue}

import java.util.{Date, UUID}

abstract class ModelBuilder {
  implicit val formats: Formats = DefaultFormats

  def fromJson(jValue: JValue): Model

  // TODO
  def dateFromJson(jString: JString): Date = new Date()

  def uuidFromJson(jString: JString): UUID = ???
}

object ModelBuilder {
  val METADATA_TYPE = "metadata_type"
  val PROVENANCE = "provenance"
}
