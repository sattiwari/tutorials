package scala.talks.mar2009

import scala.util.control.Breaks._

object BreakDemo extends App {

  val elems = List(1)

  breakable {
    for (x <- elems) {
      println(x*2)
      if(x > 0) break
    }
  }
}
