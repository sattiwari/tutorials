package scala.talks.jun2011.scalaExchange

import java.io.{File, PrintWriter}

import scala.io.Source

class PhoneCoder(words: List[String]) {

  private val mapping = Map(
    '0' -> "e", '1' -> "jnq", '2' -> "rwx", '3' -> "dsy", '4' -> "ft",
    '5' -> "am", '6' -> "civ", '7' -> "bku", '8' -> "lop", '9' -> "ghz"
  )

  private val charM̦ap: Map[Char, Char] =
    for((digit, str) <- mapping; ch <- str) yield (ch -> digit)

  private def toWordNum(word: String): String =
    word.toLowerCase.filter(_.isLetter).map(charM̦ap)

  private val wordsForNum: Map[String, List[String]] =
    words.groupBy(toWordNum) withDefaultValue(List())

  def encode(num: String): Set[List[String]] = {
    if(num.isEmpty) Set(List())
    else {
      for {
        splitPoint <- 1 to num.length
        word <- wordsForNum(num take splitPoint)
        rest <- encode(num drop splitPoint)
      } yield word :: rest
    }.toSet
  }

  def translate(num: String): Set[String] = {
    val validNum = num.filter(_.isDigit)
    encode(validNum) map(_ mkString " ")
  }

}

object PhoneCoder extends App {

  val input = Source.fromFile("/tmp/z1000.t").getLines()
  val dict = Source.fromFile("/tmp/dict").getLines().toList
  val outputWriter = new PrintWriter(new File("/tmp/output"))

  val coder = new PhoneCoder(dict)

  val start = System.currentTimeMillis()
  input.foreach { in =>
    val output = coder.translate(in)
    output.foreach(o => outputWriter.write(s"${in}: ${o}\n"))
  }
  outputWriter.close()
  val end = System.currentTimeMillis()

  val timeTaken = end - start
  println(s"program completed in ${timeTaken} millis")


}