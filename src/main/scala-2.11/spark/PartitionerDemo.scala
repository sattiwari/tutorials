package tutorials.spark

/**
  * Created by stiwari on 8/26/2016 AD.
  */
object PartitionerDemo extends App with SparkJob {
  val pairs = sc.parallelize(List((1, 1), (2, 2), (3, 3)))
  println(pairs.partitioner)

  import org.apache.spark.HashPartitioner
  val partitioned = pairs.partitionBy(new HashPartitioner(2))
  println(partitioned.partitioner)
}
