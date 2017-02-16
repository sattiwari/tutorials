package codility

/**
  * Created by stiwari on 2/9/2017 AD.
  */
object lesson5_1 extends App {

  def solution(a: Int, b: Int, k: Int): Int = {
    (a to b).filter(_ % k == 0).length
  }

  val res = solution(6, 11, 2)
  println(res)

}
