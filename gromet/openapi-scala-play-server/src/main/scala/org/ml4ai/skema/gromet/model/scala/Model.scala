package org.ml4ai.skema.gromet.model.scala

import org.json4s.{JString, JValue}

import java.util.Date

abstract class Model {
  def toJson: JValue

  def toJson(date: Date): JString = new JString("hello")
}

object Model {
  def dateFromJson(json: JValue): Date = null
}