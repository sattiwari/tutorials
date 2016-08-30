package tutorials.spark

/**
  * Created by stiwari on 8/26/2016 AD.
  */
object PairedRDDDemo extends App with SparkJob {
  val input = sc.textFile("/tmp/README.md")
  val rdd = input.flatMap(line => line.split(" ")).map(word => (word, 1))
  val result = rdd.combineByKey(
    (v) => (v, 1),
    (acc: (Int, Int), value: Int) => (acc._1 + value, acc._2 + 1),
    (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._1)
  ).map{ case (k, v) => (k, v._1 / v._2.toFloat)}
  result.collectAsMap().foreach(println)
}

object ParallelismDemo extends SparkJob {
  val data = Seq(("a", 3), ("b", 4), ("a", 1))
  sc.parallelize(data).reduceByKey(_ + _) //default parallelism
  sc.parallelize(data).reduceByKey(_ + _, 10) //custom parallelism
}