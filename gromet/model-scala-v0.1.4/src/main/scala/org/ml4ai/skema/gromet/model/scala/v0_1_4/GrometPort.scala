package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class GrometPort(
  metadataOpt: Option[Int] = None, // GrometObject
  idOpt: Option[Int] = None,
  nameOpt: Option[String] = None,
  boxOpt: Option[Int] = None,
) extends Model {
  import GrometPort._

  def metadata: Int = metadataOpt.get
  def id: Int = idOpt.get
  def box: Int = boxOpt.get

  def toJson: JValue = {
    (METADATA -> metadataOpt) ~
    (ID -> idOpt) ~
    (NAME -> nameOpt) ~
    (BOX -> boxOpt)
  }
}

object GrometPort extends ModelBuilder {
  val METADATA = "metadata"
  val ID = "id"
  val NAME = "name"
  val BOX = "box"

  override val keys = Set(
    METADATA,
    ID,
    NAME,
    BOX
  )

  def fromJson(jValue: JValue): GrometPort = {
    checkKeys(jValue)

    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
    val idOpt = (jValue \ ID).extractOpt[Int]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val boxOpt = (jValue \ BOX).extractOpt[Int]

    GrometPort(
      metadataOpt,
      idOpt,
      nameOpt,
      boxOpt
    )
  }
}
