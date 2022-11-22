package org.ml4ai.skema.gromet.model.scala

import org.json4s.JsonAST.JObject
import org.json4s.{DefaultFormats, Formats, JField, JValue}
import org.json4s.JsonDSL._

case class Metadata(
  provenanceOpt: Option[Provenance]
) extends Model {
  import Metadata._

  def toJson: JValue = new JObject(List(
    JField(PROVENANCE, provenanceOpt.map(_.toJson))
  ))
}

object Metadata {
  implicit val formats: Formats = DefaultFormats

  val PROVENANCE = "PROVENANCE"

  def fromJson(jValue: JValue): Metadata = {
    val provenanceOpt = (jValue \ PROVENANCE).extractOpt[JValue].map(Provenance.fromJson)

    Metadata(
      provenanceOpt
    )
  }
}

