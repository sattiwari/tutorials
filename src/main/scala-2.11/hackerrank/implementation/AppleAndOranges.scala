package hackerrank.implementation

object AppleAndOranges {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var s = sc.nextInt();
    var t = sc.nextInt();
    var a = sc.nextInt();
    var b = sc.nextInt();
    var m = sc.nextInt();
    var n = sc.nextInt();
    var apple = new Array[Int](m);
    for(apple_i <- 0 to m-1) {
      apple(apple_i) = sc.nextInt();
    }
    var orange = new Array[Int](n);
    for(orange_i <- 0 to n-1) {
      orange(orange_i) = sc.nextInt();
    }

    println(apple.count(i => (a+i<=t) && (a+i>=s)))
    println(orange.count(i => (b+i<=t) && (b+i>=s)))



  }

}
