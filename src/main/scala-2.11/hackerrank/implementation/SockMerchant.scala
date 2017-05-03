package hackerrank.implementation

import hackerrank.Utils._
/**
  * Created by stiwari on 5/4/2017 AD.
  */
object SockMerchant {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var c = new Array[Int](n);
    for(c_i <- 0 to n-1) {
      c(c_i) = sc.nextInt();
    }
    val res = c.groupBy(identity).mapValues(_.length).map(_._2).map(t => t/2).sum
    println(res)
  }

}
