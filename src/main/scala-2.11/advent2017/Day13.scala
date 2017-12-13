package advent2017

import advent2017.Utils._

case class Layer(depth: Int, range: Int, scannerPosition: Int = 0)

case class Firewall(layers: List[Layer]) {

  val maxDepth = layers.last.depth

  private def updateScannerPositions(positions: List[(Int, Int)]): List[(Int, Int)] = {
    positions.zipWithIndex.map { case (elem, idx) =>
      val (position, direction) = elem
      if (position == -1) (-1, 0)
      else if (position == 0) (1, 1)
      else {
        val layer = layers(idx)
        if (position == layers(idx).range - 1) (position - 1, -1)
        else (position + direction, direction)
      }
    }
  }

  private def caughtPositions(scannerPositions: List[(Int, Int)], time: Int, res: List[Int]): List[Int] = {
//    println(s"time ${time} scanner positions ${scannerPositions.filter(_._1 >= 0).mkString(",")}")
    if (time > maxDepth) res
    else {
      if (scannerPositions(time)._1 == 0)
        caughtPositions(updateScannerPositions(scannerPositions), time + 1, time :: res)
      else
        caughtPositions(updateScannerPositions(scannerPositions), time + 1, res)
    }
  }

  def getSeverity(): Int = {
    val scannerPositions = layers.map { l =>
      if (l.range == 0) (-1,0)
      else (0,1)
    }
    val cps = caughtPositions(scannerPositions, 0, List.empty[Int])
    cps.map(cp => layers(cp).depth * layers(cp).range).sum
  }



  def packetPositions: Map[Int, Int] =
    layers.map(l => l.depth -> 0).toMap
}

object Firewall {

  def createFirewall(inputMap: Map[Int, Int]): Firewall = {
    val maxDepth = inputMap.keySet.max

    val layers = (0 to maxDepth).map { depth =>
      if (inputMap.contains(depth)) Layer(depth, inputMap(depth))
      else Layer(depth, 0)
    }.toList

    Firewall(layers)
  }
}

object Day13 extends App {

  val lines = getInput("/advent2017/day13.txt")

  val inputMap: Map[Int, Int] = lines.map { line =>
    val ts = line.split(":").map(_.trim.toInt)
    (ts(0) -> ts(1))
  }.toMap

  val firewall = Firewall.createFirewall(inputMap)
  val res = firewall.getSeverity()

  println(res)

}
