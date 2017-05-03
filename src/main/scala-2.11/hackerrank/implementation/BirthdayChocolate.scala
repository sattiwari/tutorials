package hackerrank.implementation

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object BirthdayChocolate {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var squares = new Array[Int](n);
    for(squares_i <- 0 to n-1) {
      squares(squares_i) = sc.nextInt();
    }
    var d = sc.nextInt();
    var m = sc.nextInt();

    println(squares.sliding(m).count(_.sum == d))
  }

}
