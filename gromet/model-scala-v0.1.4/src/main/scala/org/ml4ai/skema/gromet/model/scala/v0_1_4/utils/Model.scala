package org.ml4ai.skema.gromet.model.scala.v0_1_4.utils

import org.json4s.{JString, JValue}

import java.util.{Date, UUID}

abstract class Model {
  def toJson: JValue

  def toJson(date: Date): JString = JString("hello")

  def toJson(uuid: UUID): JString = JString(uuid.toString)

//  def toJson(metadataTypeOpt: Option[String]): JField = {
//    new JField(ModelBuilder.METADATA_TYPE, metadataTypeOpt.map(JString).getOrElse(JNull))
//  }
//  def toJson(provenanceOpt: Option[Provenance]): JField = {
//    new JField(ModelBuilder.PROVENANCE, provenanceOpt.map(_.toJson).getOrElse(JNull))
//  }
}

object Model