package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class Provenance(
  methodOpt: Option[String] = None,
  timestampOpt: Option[String] = None // TODO
) extends Model {
  import Provenance._

  def method: String = methodOpt.get
  def timestamp: String /*Date*/ = timestampOpt.get

  def toJson: JValue = {
    (METHOD -> methodOpt) ~
    (TIMESTAMP -> timestampOpt) // .map(toJson))
  }
}

object Provenance extends ModelBuilder {
  val METHOD = "method"
  val TIMESTAMP = "timestamp"

  def fromJson(jValue: JValue): Provenance = {
    val methodOpt = (jValue \ METHOD).extractOpt[String]
    val timestampOpt = (jValue \ TIMESTAMP).extractOpt[String] // [JString].map(dateFromJson)

    Provenance(
      methodOpt,
      timestampOpt
    )
  }
}
