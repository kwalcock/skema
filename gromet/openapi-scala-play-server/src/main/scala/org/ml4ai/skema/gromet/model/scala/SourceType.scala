package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JString, JValue}
import org.json4s.JsonDSL._

case class SourceType(
  value: String
) extends Model {
  import SourceType._

  def toJson: JValue = new JString(value)
}

object SourceType {
  implicit val formats: Formats = DefaultFormats

  def fromJson(jValue: JValue) = {
    val value = jValue.asInstanceOf[JString].s

    SourceType(value)
  }
}
