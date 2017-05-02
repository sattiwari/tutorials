package hackerrank.warmup

import scala.collection.mutable.ListBuffer

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object DiagonalDifference {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var a = Array.ofDim[Int](n,n);
    for(a_i <- 0 to n-1) {
      for(a_j <- 0 to n-1){
        a(a_i)(a_j) = sc.nextInt();
      }
    }

    var (a_i, b_i) = (-1, n)
    val res = a.foldLeft((0, 0)){ (acc, i) =>
      a_i += 1
      b_i -= 1
      (acc._1 + i(a_i), i(b_i) + acc._2)
    }

    println((res._1 - res._2).abs)
  }

}
