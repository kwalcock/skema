package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.{JString, JValue}
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class FunctionType(
  value: String
) extends Model {
  import FunctionType._

  require(values(value))

  def toJson: JValue = JString(value)
}

object FunctionType extends ModelBuilder {
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
