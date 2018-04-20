package scala

import scala.io.Source

object FilesDiff extends App {

  val path1 = "/Users/stiwari/analysis/v2a"
  val path2 = "/Users/stiwari/analysis/v3a"

  val file1 = Source.fromFile(path1).getLines().toSet
  val file2 = Source.fromFile(path2).getLines().toSet

  val diff = file2.diff(file1)

  diff.foreach(println)


}
