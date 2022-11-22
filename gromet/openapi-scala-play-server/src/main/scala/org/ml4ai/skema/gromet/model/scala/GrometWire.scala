package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class GrometWire(
  nameOpt: Option[String] = None,
  srcOpt: Option[Int] = None,
  tgtOpt: Option[Int] = None,
  metadataOpt: Option[Int] = None
) extends Model {
  import GrometWire._

  def toJson: JValue = {
    (NAME -> nameOpt) ~
    (SRC -> srcOpt) ~
    (TGT -> tgtOpt) ~
    (METADATA -> metadataOpt)
  }
}

object GrometWire {
  implicit val formats: Formats = DefaultFormats

  val NAME = "name"
  val SRC = "src"
  val TGT = "tgt"
  val METADATA = "metadata"

  def fromJson(jValue: JValue): GrometWire = {
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val srcOpt = (jValue \ SRC).extractOpt[Int]
    val tgtOpt = (jValue \ TGT).extractOpt[Int]
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]

    GrometWire(
      nameOpt,
      srcOpt,
      tgtOpt,
      metadataOpt
    )
  }
}
