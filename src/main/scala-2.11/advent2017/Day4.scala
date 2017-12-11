package advent2017

import scala.io.Source

object Day4 extends App {

  def validPassphrases(input: List[String]) = {
    input
      .map(e => e.split(" "))
      .filter(l => l.length == l.distinct.length)
      .length
  }

  val stream = getClass.getResourceAsStream("/advent2017/day4.txt")
  val records = Source.fromInputStream(stream).getLines().toList

  val res = validPassphrases(records)
  println(res)


}
