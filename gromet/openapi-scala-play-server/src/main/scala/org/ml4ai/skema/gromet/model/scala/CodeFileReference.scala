package org.ml4ai.skema.gromet.model.scala

import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._

case class CodeFileReference (
  uidOpt: Option[String] = None,
  nameOpt: Option[String] = None,
  pathOpt: Option[String] = None
) extends Model {
  import CodeFileReference._

  def uid: String = uidOpt.get
  def name: String = nameOpt.get
  def path: String = pathOpt.get

  def toJson: JValue = {
    (UID -> uidOpt) ~
    (NAME -> nameOpt) ~
    (PATH -> pathOpt)
  }
}

object CodeFileReference {
  implicit val formats: Formats = DefaultFormats

  // This could be a map of fields, each with toJson and fromJson
  // Would like to know all keys in case there is something extra in error.
  // Maybe toJson given a CodeFileReference so that can extract things from it?
  // CodeFileReference to inherit from Model[CodeFileReference] (the class).
  // Has ListMap of keys and functions for to and from?

  val UID = "uid"
  val NAME = "name"
  val PATH = "path"

  def fromJson(jValue: JValue): CodeFileReference = {
    val uidOpt = (jValue \ UID).extractOpt[String]
    val nameOpt = (jValue \ NAME).extractOpt[String]
    val pathOpt = (jValue \ PATH).extractOpt[String]

    CodeFileReference(
      uidOpt,
      nameOpt,
      pathOpt
    )
  }
}
