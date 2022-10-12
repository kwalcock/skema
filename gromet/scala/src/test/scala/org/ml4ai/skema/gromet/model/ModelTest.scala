package org.ml4ai.skema.gromet.model

import io.swagger.client.ApiInvoker
import io.swagger.client.model.GrometFNModule
import org.ml4ai.skema.gromet.test.Test

import java.nio.charset.StandardCharsets
import scala.io.{Codec, Source}

class ModelTest extends Test {
  val codec = new Codec(StandardCharsets.UTF_8)

  behavior of "model"

  def run(name: String): Unit = {
    it should s"deserialize $name" in {
      val resourceName =  s"examples/$name/FN_0.1.4/$name--Gromet-FN-auto.json"
      val source = Source.fromResource(resourceName)(codec)
      val text = source.mkString
      source.close()
      ApiInvoker.deserialize(text, "", classOf[GrometFNModule])
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
