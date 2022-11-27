package org.ml4ai.skema.gromet.model.scala.v0_1_4.utils

import org.json4s.JValue

abstract class MetadataModelBuilder extends ModelBuilder {

  override def fromJson(jValue: JValue): MetadataModel
}
