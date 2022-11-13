package org.ml4ai.skema.gromet.model

import io.swagger.client.ApiInvoker
import org.ml4ai.skema.gromet.common.utils.FileUtils
import org.ml4ai.skema.gromet.model.swagger.scala.GrometFNModule
import org.ml4ai.skema.gromet.test.Test

class ModelTest extends Test {

  behavior of "model"

  def run(name: String): Unit = {
    it should s"deserialize $name" in {
      val resourceName =  s"/examples/$name/FN_0.1.4/$name--Gromet-FN-auto.json"
      val text = FileUtils.textFromResource(resourceName)
      val result = ApiInvoker.deserialize(text, "", classOf[GrometFNModule]).asInstanceOf[GrometFNModule]
      val nothing = ApiInvoker.serialize(result)

      println(result)
      println(nothing)
    }
  }

  val tests = Array(
    "cond1",
    "dict1",
    "exp0",
    "exp1",
    "exp2",
    "for1",
    "fun1",
    "fun2",
    "fun3",
    "fun4",
    "while1",
    "while2",
    "while3"
  )

  tests.foreach {test =>
    run(test)
  }
}
