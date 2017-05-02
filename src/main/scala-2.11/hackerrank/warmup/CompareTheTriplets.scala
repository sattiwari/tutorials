package hackerrank.warmup

object CompareTheTriplets {

  def compare(a: List[Int], b: List[Int]) = {
    var (aScore, bScore) = (0, 0)
    a.zip(b).foreach{ case (a, b) =>
      if(a < b) bScore += 1
      if(a < b) aScore += 1
    }
    (aScore, bScore)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var a0 = sc.nextInt();
    var a1 = sc.nextInt();
    var a2 = sc.nextInt();
    var b0 = sc.nextInt();
    var b1 = sc.nextInt();
    var b2 = sc.nextInt();

    val a = List(a0, a1, a2)
    val b = List(b0, b1, b2)

    val (aScore, bScore) = compare(a, b)
    println(s"$aScore $bScore")

  }

}
