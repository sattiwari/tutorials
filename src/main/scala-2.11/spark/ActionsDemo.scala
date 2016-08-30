package tutorials.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
  * Created by stiwari on 8/26/2016 AD.
  */

trait SparkJob {
  // Create scala spark context
  val conf = new SparkConf().setMaster("local").setAppName("My App")
  val sc = new SparkContext(conf)
}

object ActionsDemo extends App with SparkJob {
  val input = sc.parallelize(List(1, 2, 3, 4, 5))
  val sum = input.reduce(_ + _)
  println(sum)

  val result = input.aggregate((0, 0))(
    (acc, value) => (acc._1 + value, acc._2 + 1),
    (acc1, acc2) => (acc1._1 + acc2._1, acc1._2 + acc2._2)
  )
  val avg = result._1 / result._2.toDouble
  println(avg)
}
