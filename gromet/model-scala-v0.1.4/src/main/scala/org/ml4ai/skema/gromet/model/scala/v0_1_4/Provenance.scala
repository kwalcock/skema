package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

import java.time.OffsetDateTime

case class Provenance(
  methodOpt: Option[String] = None,
  timestampOpt: Option[OffsetDateTime] = None
) extends Model {
  import Provenance._

  def method: String = methodOpt.get
  def timestamp: OffsetDateTime = timestampOpt.get

  def toJson: JValue = {
    (METHOD -> methodOpt) ~
    (TIMESTAMP -> timestampOpt.map(toJson))
  }
}

object Provenance extends ModelBuilder {
  val METHOD = "method"
  val TIMESTAMP = "timestamp"

  override val keys = Set(
    METHOD,
    TIMESTAMP
  )

  def fromJson(jValue: JValue): Provenance = {
    checkKeys(jValue)

    val methodOpt = (jValue \ METHOD).extractOpt[String]
    val timestampOpt = (jValue \ TIMESTAMP).extractOpt[JValue].map(offsetDateTimeFromJson)

    Provenance(
      methodOpt,
      timestampOpt
    )
  }
}
