package org.ml4ai.skema.gromet.model.scala

import org.json4s.jackson.JsonMethods
import org.ml4ai.skema.gromet.test.Test

class EquationDefinitionTest extends Test {

  behavior of "EquationDefinition"

  it should "serialize" in {
    val value = EquationDefinition()
    val json = value.toJson
    val text = JsonMethods.pretty(json)

    println(text)
  }

  it should "deserialize" in {
    val text = """
        |{
        |  "metadataType": "example metadataType",
        |  "equationExtraction": {
        |    "sourceType": "example sourceType",
        |    "documentReferenceUid": "example documentReferenceUid",
        |    "equationNumber": 42
        |  },
        |  "equationMathmlSource": "example equationMathmlSource",
        |  "equationLatexSource": "exampleEquationLatexSource",
        |  "provenance": {
        |    "method": "example method",
        |    "timestamp": "2022-09-15 08:21:34.705840"
        |  }
        |}
        |""".stripMargin
    val json = JsonMethods.parse(text)
    val value = EquationDefinition.fromJson(json)

    println(value)
  }

  it should "survive a round trip" in {

  }
}
