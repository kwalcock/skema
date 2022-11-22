package org.ml4ai.skema.gromet.model.scala

import org.json4s.JsonAST.JString
import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class ImportType(
  value: String
) extends Model {

  def toJson: JValue = JString(value)
}

object ImportType {

  def fromJson(jValue: JValue): ImportType = {
    val value = jValue.asInstanceOf[JString].s

    ImportType(value)
  }
}
