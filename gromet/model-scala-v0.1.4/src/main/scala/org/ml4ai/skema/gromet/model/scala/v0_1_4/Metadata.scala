package org.ml4ai.skema.gromet.model.scala.v0_1_4

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.ml4ai.skema.gromet.model.scala.v0_1_4.utils.{Model, ModelBuilder}

case class Metadata(
  provenanceOpt: Option[Provenance]
) extends Model {
  import Metadata._

  def toJson: JValue = {
    (PROVENANCE -> provenanceOpt.map(_.toJson))
  }
}

object Metadata extends ModelBuilder {
  val PROVENANCE = "PROVENANCE"

  def fromJson(jValue: JValue): Metadata = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    Metadata(
      provenanceOpt
    )
  }
}
