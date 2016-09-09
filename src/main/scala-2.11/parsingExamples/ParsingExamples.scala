package parsingExamples

import scala.util.parsing.combinator._

/**
  * Created by stiwari on 9/5/2016 AD.
  */

object RepeatParser extends JavaTokenParsers {
  var count = 0

  def repeat = "repeat" ~> n <~ "times" ~ block
  def n = wholeNumber ^^ { reps => count = reps.toInt}
  def block = "{" ~> lines <~ "}"
  def lines = rep(line)
  def line = "say" ~> message ^^ { msg =>
    for (i <- 1 to count) println(msg)
  }
  def message = stringLiteral
}

object ParsingExamples extends App {
  val input = """repeat 10 times {
  say "hello"
  say "world!"
}"""

  RepeatParser.parseAll(RepeatParser.repeat, input)
}

