package codility

/**
  * Created by stiwari on 2/8/2017 AD.
  */
object Lesson3_1 extends App {

  val (x, y, d) = (10, 85, 30)

  val res = {
    val a = (y-x) / d
    if((y-x)%d == 0) a else a + 1
  }

  println(res)

}
