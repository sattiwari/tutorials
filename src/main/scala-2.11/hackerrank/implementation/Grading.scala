package hackerrank.implementation

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object Grading {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var grades = new Array[Int](n);
    for(grades_i <- 0 to n-1) {
      grades(grades_i) = sc.nextInt();
    }

    grades.map { i =>
      val x = 5 - (i % 5)
      if(i + x >= 40 && x < 3) i+x
      else i
    }.foreach(println)
  }

}
