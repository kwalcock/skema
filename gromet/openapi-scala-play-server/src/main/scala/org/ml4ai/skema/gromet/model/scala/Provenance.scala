package org.ml4ai.skema.gromet.model.scala

import org.json4s.JValue
import org.json4s.JsonDSL._

import java.util.Date

case class Provenance(
  methodOpt: Option[String] = None,
  timestampOpt: Option[Date] = None
) extends Model {
  import Provenance._

  def method: String = methodOpt.get
  def timestamp: Date = timestampOpt.get

  def toJson: JValue = {
    (METHOD -> methodOpt) ~
    (TIMESTAMP -> timestampOpt.map(toJson))
  }
}

object Provenance extends ModelBuilder {
  val METHOD = "method"
  val TIMESTAMP = "timestamp"

  def fromJson(jValue: JValue): Provenance = {
    val methodOpt = (jValue \ METHOD).extractOpt[String] // These should throw an exception if can't make translation TODO
    val timestampOpt = (jValue \ TIMESTAMP).extractOpt[JValue].map(dateFromJson)

    Provenance(
      methodOpt,
      timestampOpt
    )
  }
}