package hackerrank.implementation

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object BreakingTheRecords {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var score = new Array[Int](n);
    for(score_i <- 0 to n-1) {
      score(score_i) = sc.nextInt();
    }

    val (minS, maxS, minB, maxB) = score.foldLeft((score(0), score(0), 0, 0)){(acc, elem) =>
      var (minS, maxS, minB, maxB) = acc
      if(elem < minS) {minS = elem; minB += 1}
      if(elem > maxS) {maxS = elem; maxB += 1}
      (minS, maxS, minB, maxB)
    }

    println(s"$maxB $minB")
  }

}
