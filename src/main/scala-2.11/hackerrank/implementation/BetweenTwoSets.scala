package hackerrank.implementation

/**
  * Created by stiwari on 5/3/2017 AD.
  */
// 10:55
object BetweenTwoSets {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var m = sc.nextInt();
    var a = new Array[Int](n);
    for(a_i <- 0 to n-1) {
      a(a_i) = sc.nextInt();
    }
    var b = new Array[Int](m);
    for(b_i <- 0 to m-1) {
      b(b_i) = sc.nextInt();
    }

    val (a1, b1) = (a.toSet, b.toSet)
    val all  = a.union(b)
    val (min, max) = (all.min, all.max)

    println((min to max).count(i => a1.forall(j => i % j == 0 ) && b1.forall(j => j % i == 0)))

  }

}
