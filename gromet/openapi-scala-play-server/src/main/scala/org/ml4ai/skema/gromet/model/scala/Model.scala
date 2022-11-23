package org.ml4ai.skema.gromet.model.scala

import org.json4s.{JField, JNull, JString, JValue}

import java.util.Date

abstract class Model {
  def toJson: JValue

  def toJson(date: Date): JString = new JString("hello")

//  def toJson(metadataTypeOpt: Option[String]): JField = {
//    new JField(ModelBuilder.METADATA_TYPE, metadataTypeOpt.map(JString).getOrElse(JNull))
//  }
//  def toJson(provenanceOpt: Option[Provenance]): JField = {
//    new JField(ModelBuilder.PROVENANCE, provenanceOpt.map(_.toJson).getOrElse(JNull))
//  }
}

object Model