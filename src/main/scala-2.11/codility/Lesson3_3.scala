package codility

/**
  * Created by stiwari on 2/8/2017 AD.
  */
object Lesson3_3  extends App {

  def foo(a: Array[Int], sum: Int, diff: Int): Int = {
    if(a.isEmpty) diff
    else {
      val sum1 = sum + a.head
      val diff1 = Math.abs(sum1 - a.tail.sum)
      if(diff1 < diff) foo(a.tail, sum1, diff1)
      else foo(a.tail, sum1, diff)

    }
  }

  val a = Array(1, 2)

  val len = a.length

  val res = (1 to len - 1).map{ x =>
    Math.abs(a.take(x).sum - a.drop(x).sum)
  }.min


  println(res)


}
