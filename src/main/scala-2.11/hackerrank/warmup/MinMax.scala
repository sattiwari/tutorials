package hackerrank.warmup

import scala.io

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object MinMax {

  def main(args: Array[String]): Unit = {
    val arr = io.Source.stdin.getLines().take(1).toList
    val a1 = arr(0).split(" ").map(_.toLong).sorted
    val (all, first, last) = (a1.sum, a1.head, a1.last)
    val (min, max) = (all - last, all - first)
    println(s"$min $max")
  }

}
