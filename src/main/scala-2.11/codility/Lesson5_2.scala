package codility

/**
  * Created by stiwari on 2/9/2017 AD.
  */
object Lesson5_2 extends App {

  def solution(a: Array[Int]): Int = {
    def foo(a: Array[Int], pairs: Int): Int = {
      if(a.isEmpty || a.tail.isEmpty) pairs
      else {
        val x = a.dropWhile(_ == 1)
        val count = x.count(_ == 1)
        if(x.isEmpty || count == 0) pairs
        else foo(x.tail, pairs + count)
      }
    }
    foo(a, 0)
  }

//  def solution(a: Array[Int]): Int = {
//    val neg = a.forall(_ == 0) || a.forall(_ == 1)
//    if(neg) return 0
//    else {
//      a.groupBy(_ == 0).map{ case (k,v) =>
//        k -> v.count(_ == 1)
//      }
//    }
//  }

//  println(solution(Array(1, 1, 1, 1, 1)))
//
  assert(solution(Array(1, 1, 1, 1, 1)) == 0)
  assert(solution(Array(0, 0, 0, 0, 0)) == 0)
  assert(solution(Array(0, 1, 0, 1, 1)) == 5)


}
