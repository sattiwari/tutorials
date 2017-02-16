package codility

/**
  * Created by stiwari on 2/8/2017 AD.
  */
object Lesson2_02 extends App {

  def solution(a: Array[Int], k: Int): Array[Int] = {
    val len = a.length
    val k1 = if(k > len) k % len else k
    a.takeRight(k1) ++ a.take(len - k1)
  }



  val a = Array(1, 2)
  val k = 1
  val len = a.length
  val k1 = if(k > len) k % len else k


  val x = solution(a, k)
  println(x.mkString(""))

}
