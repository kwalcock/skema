package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class GrometWire(
  metadataOpt: Option[Int] = None, // GrometObject
  nameOpt: Option[String] = None,
  srcOpt: Option[Int] = None,
  tgtOpt: Option[Int] = None,
) extends Model {
  import GrometWire._

  def metadata: Int = metadataOpt.get
  def name: String = nameOpt.get
  def src: Int = srcOpt.get
  def tgt: Int = tgtOpt.get

  def toJson: JValue = {
    (METADATA -> metadataOpt) ~
    (NAME -> nameOpt) ~
    (SRC -> srcOpt) ~
    (TGT -> tgtOpt)
  }
}

object GrometWire extends ModelBuilder {
  val METADATA = "metadata"
  val NAME = "name"
  val SRC = "src"
  val TGT = "tgt"

  override val keys = Set(
    METADATA,
    NAME,
    SRC,
    TGT
  )

  def fromJson(jValue: JValue): GrometWire = {
    checkKeys(jValue)

    val metadataOpt = (jValue \ METADATA).extractOpt[Int]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val srcOpt = (jValue \ SRC).extractOpt[Int]
    val tgtOpt = (jValue \ TGT).extractOpt[Int]

    GrometWire(
      metadataOpt,
      nameOpt,
      srcOpt,
      tgtOpt
    )
  }
}
