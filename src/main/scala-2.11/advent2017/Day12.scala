package advent2017

import advent2017.Utils._

import scala.annotation.tailrec

object Day12 extends App {

  val lines = getInput("/advent2017/day12.txt")

  val input: Map[String, List[String]] = lines.map { line =>
    val ts = line.split(" <-> ")
    val (src, des) = (ts(0), ts(1))
    val desList = ts(1).split(",").toList
    (src -> desList)
  }.toMap

  def connections(input: Map[String, List[String]]): Int = {

    @tailrec
    def loop(toVisit: List[String], visited: List[String]): List[String] = {
      toVisit match {
        case Nil => visited
        case h :: tail =>
          if (visited.contains(h)) {
            loop(tail, visited)
          } else {
            val newNodes = input(h.trim).filterNot(visited.contains).map(_.trim)
            loop(tail ++ newNodes, h.trim :: visited)
          }
      }
    }

    val visited = loop(input("0"), List("0"))
    visited.size
  }

  val x = connections(input)
  println(x)

}
