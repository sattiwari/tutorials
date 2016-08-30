package tutorials.spark

/**
  * Created by stiwari on 8/26/2016 AD.
  */
object TransformationsDemo extends App with SparkJob {
  val input = sc.parallelize(List(1, 2, 3, 4, 5))
  val result = input.map(x => x*x)
  println(result.collect.mkString(","))
}
