package codility

/**
  * Created by stiwari on 2/9/2017 AD.
  */
object Lesson4_2 extends App {

  val a = Array(3)

  def solution(x: Int, a: Array[Int]): Int = {
    val neg = (1 to x).filterNot(a.contains(_))

    if(neg.nonEmpty) -1
    else a.zipWithIndex.groupBy(_._1).map{ case (x, gp) => gp.map(_._2).min}.max
  }

  val res = solution(5, a)

  println(res)

}
