package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.{JString, JValue}

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
