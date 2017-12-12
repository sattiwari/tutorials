package advent2017

import Utils._

class Tree(map: Map[String, List[String]]) {

  val nodes = map.keySet

  val tree = map.filter(_._2.nonEmpty).flatMap { case (parent, children) =>
    children.map { child =>
      child -> parent
    }
  }

  val childNodes = tree.keySet

  val root = nodes.diff(childNodes).head


}

object Day7 extends App {

  val lines = getInput("/advent2017/day7.txt")

  val map = lines.map { line =>
    val ts = line.split(" -> ")

    val (parent, children) = {
      if(ts.length == 1) (ts(0).split(" ")(0), List.empty[String])
      else (ts(0).split(" ")(0), ts(1).split(",").map(_.trim).toList)
    }

    (parent -> children)
  }.toMap

  val tree = new Tree(map)
  val root = tree.root

  println(root)
}
