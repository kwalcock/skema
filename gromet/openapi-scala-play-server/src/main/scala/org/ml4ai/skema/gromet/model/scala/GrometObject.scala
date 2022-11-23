package org.ml4ai.skema.gromet.model.scala

import org.json4s.JValue
import org.json4s.JsonDSL._

case class GrometObject(
  metadataOpt: Option[Int] = None
) extends Model {
  import GrometObject._

  def toJson: JValue = {
    (METADATA -> metadataOpt)
  }
}

object GrometObject extends ModelBuilder {
  val METADATA = "metadata"

  def fromJson(jValue: JValue): GrometObject = {
    val metadataOpt = (jValue \ METADATA).extractOpt[Int]

    GrometObject(
      metadataOpt
    )
  }
}
