package codility

/**
  * Created by stiwari on 2/8/2017 AD.
  */
object Lesson4_1 extends App {

  val a = Array(1, 3, 6, 4, 1, 2)

  val res = (1 to 100000).filterNot(a.contains(_)).head

  println(res)

}
