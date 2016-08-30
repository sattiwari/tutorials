package tutorials.spark

import org.apache.spark.rdd.RDD

/**
  * Created by stiwari on 8/26/2016 AD.
  */
object SortingDemo extends App with SparkJob {
  val input: RDD[Int] = sc.parallelize(List(1, 2, 3, 4, 5))
  val pairedRDD = input.map((_, 1))
  implicit val sortIntegerByString = new Ordering[Int] {
    def compare(x: Int, y: Int) = x.toString compare y.toString
  }
  pairedRDD.sortByKey()
}
