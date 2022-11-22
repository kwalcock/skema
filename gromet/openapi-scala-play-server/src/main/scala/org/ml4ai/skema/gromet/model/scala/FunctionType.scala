package org.ml4ai.skema.gromet.model.scala

import org.json4s.JsonAST.JString
import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class FunctionType(
  value: String
) extends Model {
  import FunctionType._

  require(values(value))

  def toJson: JValue = JString(value)
}

object FunctionType {
  implicit val formats: Formats = DefaultFormats

  val values = Set(
    "FUNCTION",
    "EXPRESSION",
    "PREDICATE",
    "MODULE",
    "PRIMITIVE",
    "LITERAL"
  )

  def fromJson(jValue: JValue): FunctionType = {
    val value = jValue.extract[String]

    FunctionType(value)
  }
}
