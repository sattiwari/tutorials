package advent2017

import Utils._

import scala.collection.immutable

object Day6 extends App {

  val banks = getInput("/advent2017/day6.txt").head.split("\t").toList.map(_.toInt)

  def distributeBlock(banks: List[Int], remainingBlocks: Int, offset: Int): List[Int] = {
    if(remainingBlocks == 0) banks
    else {
      val updated = banks.updated(offset, banks(offset) + 1)
      val next = (offset + 1) % banks.size
      distributeBlock(updated, remainingBlocks - 1, next)
    }
  }

  def cycle(banks: List[Int]): List[Int] = {
    val biggestBlock = banks.max
    val offset = banks.indexOf(biggestBlock)
    val updated = banks.updated(offset, 0)
    val next = (offset + 1) % banks.size
    distributeBlock(updated, biggestBlock, next)
  }

  def numOfCycles(banks: List[Int]): Int = {
    val biggestBlock = banks.max
    val seenStates = List(List.empty[Int])
    val count = 0

    def loop(banks: List[Int], count: Int, seenStates: List[List[Int]]): Int = {
      val state = cycle(banks)
      if(seenStates.contains(state)) count + 1
      else {
        loop(state, count + 1, state :: seenStates)
      }
    }

    loop(banks, 0, seenStates)
  }

  val res = numOfCycles(banks)
  println(res)

}
