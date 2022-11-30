package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class GrometObject(
  metadataOpt: Option[Int] = None
) extends Model {
  import GrometObject._

  def metadata: Int = metadataOpt.get

  def toJson: JValue = {
    (METADATA -> metadataOpt)
  }
}

object GrometObject extends ModelBuilder {
  val METADATA = "metadata"

  override val keys = Set(
    METADATA
  )

  def fromJson(jValue: JValue): GrometObject = {
    checkKeys(jValue)

    val metadataOpt = (jValue \ METADATA).extractOpt[Int]

    GrometObject(
      metadataOpt
    )
  }
}
