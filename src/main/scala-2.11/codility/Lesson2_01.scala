package codility

/**
  * Created by stiwari on 2/8/2017 AD.
  */
object Lesson2_01 extends App {

  def solution(a: Array[Int]): Int = {
    a.groupBy(_.self).filter{case (k, v) => v.length % 2 == 1}.keys.head
  }
}
