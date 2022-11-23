package org.ml4ai.skema.gromet.model.scala

import org.json4s.JsonAST.JObject
import org.json4s.{JField, JValue}
import org.json4s.JsonDSL._

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
