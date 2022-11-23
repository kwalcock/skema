package org.ml4ai.skema.gromet.model.scala

import org.json4s.JValue
import org.json4s.JsonDSL._

case class TypedValue(
  typeOpt: Option[String] = None,
//  value: Option[JsObject],
  indexOpt: Option[Int] = None
) extends Model {
  import TypedValue._

  def toJson: JValue = {
    (TYPE -> typeOpt) ~
    (INDEX -> indexOpt)
  }
}

object TypedValue extends ModelBuilder {
  val TYPE = "type"
  val INDEX = "index"

  def fromJson(jValue: JValue): TypedValue = {
    val typeOpt = (jValue \ TYPE).extractOpt[String]
    val indexOpt = (jValue \ INDEX).extractOpt[Int]

    TypedValue(
      typeOpt,
      indexOpt
    )
  }
}
