package org.ml4ai.skema.gromet.model.scala

import org.json4s.{JString, JValue}
import org.json4s.JsonDSL._

case class SourceType(
  value: String
) extends Model {
  import SourceType._

  require(values(value)
  )
  def toJson: JValue = JString(value)
}

object SourceType extends ModelBuilder {
  val values = Set(
    "GROMET",
    "SOURCE_FILE",
    "REPOSITORY",
    "WEB"
  )
  def fromJson(jValue: JValue) = {
    val value = jValue.extract[String]

    SourceType(value)
  }
}
