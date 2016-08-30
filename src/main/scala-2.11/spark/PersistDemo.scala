package tutorials.spark

import org.apache.spark.storage.StorageLevel

/**
  * Created by stiwari on 8/26/2016 AD.
  */

object PersistDemo extends App with SparkJob {
  val input = sc.parallelize(List(1, 2, 3, 4, 5))
  val result = input.map(x => x*x)
  result.persist(StorageLevel.DISK_ONLY)
  println(result.count())
  println(result.collect.mkString(","))
}
