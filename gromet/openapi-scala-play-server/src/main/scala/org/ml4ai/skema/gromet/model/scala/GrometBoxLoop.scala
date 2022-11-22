package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class GrometBoxLoop(
  conditionOpt: Option[Int] = None,
  initOpt: Option[Int] = None,
  bodyOpt: Option[Int] = None,
  metadataOpt: Option[Int] = None
) extends Model {
  import GrometBoxLoop._

  def condition: Int = conditionOpt.get
  def init: Int = initOpt.get
  def body: Int = bodyOpt.get
  def metadata: Int = metadataOpt.get

  def toJson: JValue = {
    (CONDITION -> conditionOpt) ~
    (INIT -> initOpt) ~
    (BODY -> bodyOpt) ~
    (METADATA -> metadataOpt)
  }
}

object GrometBoxLoop {
  implicit val formats: Formats = DefaultFormats

  def CONDITION = "condition"
  def INIT = "init"
  def BODY = "body"
  def METADATA = "metadata"

  def fromJson(jValue: JValue): GrometBoxLoop = {
    val conditionOpt = (jValue \ CONDITION).extractOpt[Int]
    val initOpt = (jValue \ INIT).extractOpt[Int]
    val bodyOpt = (jValue \ BODY).extractOpt[Int]
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]

    GrometBoxLoop(
      conditionOpt,
      initOpt,
      bodyOpt,
      metadataOpt
    )
  }
}
