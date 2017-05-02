package hackerrank.warmup

import scala.io

/**
  * Created by stiwari on 5/2/2017 AD.
  */
object SolveMeFirst {

  def main(args: Array[String]) {
    println(io.Source.stdin.getLines().take(2).map(_.toInt).sum)
  }

}
