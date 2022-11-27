package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.{JString, JValue}

case class ImportType(
  value: String
) extends Model {
  import ImportType._

  require(values(value))

  def toJson: JValue = JString(value)
}

object ImportType extends ModelBuilder {
  val values = Set(
    "GROMET_FN_MODULE",
    "NATIVE",
    "OTHER"
  )

  def fromJson(jValue: JValue): ImportType = {
    val value = jValue.extract[String]

    ImportType(value)
  }
}
