package hackerrank.implementation

import java.util.Scanner

/**
  * Created by stiwari on 5/4/2017 AD.
  */
object BonApetit {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in)
    val (n, k) = (sc.nextInt(), sc.nextInt())
    val cost = new Array[Int](n)
    for (i <- 0 until n) {
      cost(i) = sc.nextInt()
    }
    val charge = sc.nextInt()

    val actual = (cost.take(k) ++ cost.takeRight(n-k-1)).sum.toDouble / 2

    if(charge == actual) println("Bon Appetit")
    else println(charge - actual.toInt)
  }



}
