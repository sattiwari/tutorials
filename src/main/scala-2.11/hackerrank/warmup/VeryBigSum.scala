package hackerrank.warmup

/**
  * Created by stiwari on 5/2/2017 AD.
  */
object VeryBigSum {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for(arr_i <- 0 to n-1) {
      arr(arr_i) = sc.nextInt();
    }
    val sum: Long = arr.map(_.toLong).sum
    println(sum)
  }

}
