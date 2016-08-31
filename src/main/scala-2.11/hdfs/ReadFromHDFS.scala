package hdfs

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs._

/**
  * Created by stiwari on 8/30/2016 AD.
  */
object ReadFromHDFS extends App {
  val conf = new Configuration()
  conf.set("fs.defaultFS", "hdfs://quickstart.cloudera:8020")

  val fs = FileSystem.get(conf)
}
