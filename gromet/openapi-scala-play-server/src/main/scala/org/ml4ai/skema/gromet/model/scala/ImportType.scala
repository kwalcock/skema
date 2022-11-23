package org.ml4ai.skema.gromet.model.scala

import org.json4s.JString
import org.json4s.JValue
import org.json4s.JsonDSL._

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
