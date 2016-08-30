package tutorials.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

trait SparkJob {
  // Create scala spark context
  val conf = new SparkConf().setMaster("local").setAppName("My App")
  val sc = new SparkContext(conf)
}


object WordCount extends App with SparkJob{
  // Load our input data
  val input = sc.textFile("/tmp/README.md")

  // Split it into words
  val words = input.flatMap(_.split(" "))

  // Transform into pairs and counts
  val counts = words.map(word => (word, 1)).reduceByKey(_ + _)

  // Saves the output file
  counts.saveAsTextFile("/tmp/word_count_output")

}