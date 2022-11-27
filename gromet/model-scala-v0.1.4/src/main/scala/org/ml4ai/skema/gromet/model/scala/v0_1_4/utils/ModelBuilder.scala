package org.ml4ai.skema.gromet.model.scala.v0_1_4.utils

import org.json4s.{DefaultFormats, Formats, JString, JValue}

import java.time.OffsetDateTime
import java.util.UUID

abstract class ModelBuilder {
  implicit val formats: Formats = DefaultFormats

  def fromJson(jValue: JValue): Model

  def offsetDateTimeFromJson(jValue: JValue): OffsetDateTime = {
    val string = {
      val string = jValue.extract[String]
      val date = string.slice(0, 10)
      val time = string.slice(11, string.length)
      val stringWithTime =
          if (string(10) == ' ') s"${date}T${time}"
          else string
      val stringWithZone =
        if (time.contains('+') || time.contains('-')) stringWithTime
        else s"${stringWithTime}Z"

      stringWithZone
    }

    OffsetDateTime.parse(string)
  }

  def uuidFromJson(jValue: JValue): UUID = {
    val string = jValue.extract[String]

    UUID.fromString(string)
  }
}

object ModelBuilder {
  val METADATA_TYPE = "metadata_type"
  val PROVENANCE = "provenance"
}
