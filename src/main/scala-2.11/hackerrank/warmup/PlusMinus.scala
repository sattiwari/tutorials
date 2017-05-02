package hackerrank.warmup

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object PlusMinus {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for(arr_i <- 0 to n-1) {
      arr(arr_i) = sc.nextInt();
    }

    val positive = arr.filter( _ > 0).length.toDouble / n
    val negative = arr.filter( _ < 0).length.toDouble / n
    val zeros = arr.filter( _ == 0).length.toDouble / n

    println(positive)
    println(negative)
    println(zeros)
  }

}
