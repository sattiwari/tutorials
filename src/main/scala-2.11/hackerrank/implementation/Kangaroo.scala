package hackerrank.implementation

object Kangaroo {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var x1 = sc.nextInt();
    var v1 = sc.nextInt();
    var x2 = sc.nextInt();
    var v2 = sc.nextInt();

    var res = "NO"
    if(v1 > v2) {
      while(x1 < x2) {
        if(x1 + v1 == x2 + v2) {
          res = "YES"
          x1 = 1; x2 = 0
        }
        else {
          x1 += v1
          x2 += v2
        }
      }
    }
    println(res)
  }

}
