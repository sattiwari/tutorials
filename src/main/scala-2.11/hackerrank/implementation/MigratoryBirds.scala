package hackerrank.implementation
import scala.collection.immutable

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object MigratoryBirds {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var types = new Array[Int](n);
    for(types_i <- 0 to n-1) {
      types(types_i) = sc.nextInt();
    }

    val x = types.groupBy(identity).mapValues(_.size).toList.sortBy(t => - t._2)
    val i = x.head
    val y = x.takeWhile(t => t._2 == i._2).sortBy(t => t._1).head._1
    println(y)

  }

}
