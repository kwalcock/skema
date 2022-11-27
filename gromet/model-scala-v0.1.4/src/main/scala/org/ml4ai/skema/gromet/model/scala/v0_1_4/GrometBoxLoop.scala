package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class GrometBoxLoop(
  metadataOpt: Option[Int] = None, // GrometObject
  nameOpt: Option[String] = None, // GrometBox
  conditionOpt: Option[Int] = None,
  initOpt: Option[Int] = None,
  bodyOpt: Option[Int] = None,
) extends Model {
  import GrometBoxLoop._

  def metadata: Int = metadataOpt.get
  def name: String = nameOpt.get
  def condition: Int = conditionOpt.get
  def init: Int = initOpt.get
  def body: Int = bodyOpt.get

  def toJson: JValue = {
    (METADATA -> metadataOpt) ~
    (NAME -> nameOpt) ~
    (CONDITION -> conditionOpt) ~
    (INIT -> initOpt) ~
    (BODY -> bodyOpt)
  }
}

object GrometBoxLoop extends ModelBuilder {
  val METADATA = "metadata"
  val NAME = "name"
  val CONDITION = "condition"
  val INIT = "init"
  val BODY = "body"

  override val keys = Set(
    METADATA,
    NAME,
    CONDITION,
    INIT,
    BODY
  )

  def fromJson(jValue: JValue): GrometBoxLoop = {
    checkKeys(jValue)

    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val conditionOpt = (jValue \ CONDITION).extractOpt[Int]
    val initOpt = (jValue \ INIT).extractOpt[Int]
    val bodyOpt = (jValue \ BODY).extractOpt[Int]

    GrometBoxLoop(
      metadataOpt,
      nameOpt,
      conditionOpt,
      initOpt,
      bodyOpt,
    )
  }
}
