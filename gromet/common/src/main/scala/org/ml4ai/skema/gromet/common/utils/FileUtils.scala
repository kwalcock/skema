package org.ml4ai.skema.gromet.common.utils

import java.io.FileNotFoundException
import java.nio.charset.StandardCharsets
import scala.io.{BufferedSource, Source}

object FileUtils {
  val utf8 = StandardCharsets.UTF_8.toString

  def newFileNotFoundException(path: String): FileNotFoundException = {
    val message1 = path + " (The system cannot find the path specified"
    val message2 = message1 + (if (path.startsWith("~")) ".  Make sure to not use the tilde (~) character in paths in lieu of the home directory." else "")
    val message3 = message2 + ")"

    new FileNotFoundException(message3)
  }

  def sourceFromResource(path: String, encoding: String = utf8): BufferedSource = {
    val url = Option(FileUtils.getClass.getResource(path))
      .getOrElse(throw newFileNotFoundException(path))

    Source.fromURL(url, encoding)
  }

  def textFromResource(path: String, encoding: String = utf8): String = {
    val source = FileUtils.sourceFromResource(path)
    val text = source.mkString

    source.close()
    text
  }
}
