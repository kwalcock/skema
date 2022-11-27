package org.ml4ai.skema.gromet.model.scala.v0_1_4.utils

import org.json4s.{JString, JValue}

import java.time.OffsetDateTime
import java.util.UUID

abstract class Model {
  def toJson: JValue

  def toJson(offsetDateTime: OffsetDateTime): JString = {
    val string = {
      val string = offsetDateTime.toString
      val date = string.slice(0, 10)
      val time = string.slice(11, string.length - 1) // Remove trailing Z

      s"$date $time"
    }

    JString(string)
  }

  def toJson(uuid: UUID): JString = JString(uuid.toString)
}

object Model