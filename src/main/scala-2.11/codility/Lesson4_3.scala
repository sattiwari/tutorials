package codility

/**
  * Created by stiwari on 2/9/2017 AD.
  */
object Lesson4_3 extends App {
  val arr = Array(4, 1, 3, 2)
  val n = arr.length
  val res = (1 to n).filterNot(arr.contains(_)).isEmpty

  println(res)
}
