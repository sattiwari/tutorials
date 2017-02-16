package codility

/**
  * Created by stiwari on 2/8/2017 AD.
  */
object Lesson3_2 extends App {

  val a = List(2, 3, 1, 5)
  val max = a.length + 1
  val sum = ((max * (max+1)) / 2)
  val res = sum - a.sum

  println(max, sum, res)

}
