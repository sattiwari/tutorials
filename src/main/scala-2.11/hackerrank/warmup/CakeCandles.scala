package hackerrank.warmup

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object CakeCandles {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var height = new Array[Int](n);
    for(height_i <- 0 to n-1) {
      height(height_i) = sc.nextInt();
    }

    val max = height.max
    val res = height.filter(_ == max).length

    println(res)

  }
}
