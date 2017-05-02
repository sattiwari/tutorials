package hackerrank.warmup

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object Staircase {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();

    (1 to n).map { i =>
      (List.fill(n-i)(" ") ++ List.fill(i)("#")).mkString("")
    }.foreach(println)
  }

}
