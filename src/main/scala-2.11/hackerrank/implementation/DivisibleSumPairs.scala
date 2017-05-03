package hackerrank.implementation

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object DivisibleSumPairs {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    var k = sc.nextInt();
    var a = new Array[Int](n);
    for (a_i <- 0 to n - 1) {
      a(a_i) = sc.nextInt();
    }

    val len = a.length - 1
    val pairs = for {
      (i, j) <- a.zipWithIndex
      k <- a.takeRight(len - j)
    } yield (i, k)

    println(pairs.count(t => (t._1 + t._2) % k == 0))
  }

}
