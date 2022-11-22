package org.ml4ai.skema.gromet.model.scala

import org.json4s.jackson.JsonMethods
import org.ml4ai.skema.gromet.test.Test

class CodeFileReferenceTest extends Test {

  behavior of "CodeFileReference"

  it should "serialize" in {
    val value = CodeFileReference()
    val json = value.toJson
    val text = JsonMethods.pretty(json)

    println(text)
  }

  it should "deserialize" in {
    val text = """
        |{
        |  "uid": "example uid",
        |  "name": "example name",
        |  "path": "example path"
        |}
        |""".stripMargin
    val json = JsonMethods.parse(text)
    val value = CodeFileReference.fromJson(json)

    println(value)
  }

  it should "survive a round trip" in {

  }
}
