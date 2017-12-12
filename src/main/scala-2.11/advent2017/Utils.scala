package advent2017

import scala.io.Source

object Utils {

  def getInput(path: String) = {
    val stream = getClass.getResourceAsStream(path)
    Source.fromInputStream(stream).getLines().toList
  }

}
