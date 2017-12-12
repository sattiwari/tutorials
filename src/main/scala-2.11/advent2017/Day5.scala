package advent2017

import advent2017.Utils._

object Day5 extends App {

  val lines = getInput("/advent2017/day5.txt").map(_.toInt)

  def countSteps(l: List[Int]) = {
    val len = l.length

    def nextOffset(curr: Int, l: List[Int]): Int = curr + l(curr)
    def updateList(pos: Int, l: List[Int]): List[Int] = l.updated(pos, l(pos)+1)

    def loop(curr: Int, steps: Int, l: List[Int]): Int = {
      if(curr >= len) steps
      else {
        val next = nextOffset(curr, l)
        val updated = updateList(curr, l)
        loop(next, steps + 1, updated)
      }
    }

    loop(0, 0, l)
  }

  val res = countSteps(lines)
  println(res)

}
