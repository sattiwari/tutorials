package codility

/**
  * Created by stiwari on 2/8/2017 AD.
  */
object Lesson1 extends App {

  def solution(n: Int): Int = {
    val list = "(?<=1)(0+)(?=1)".r.findAllIn(n.toBinaryString).toList
    if(list.isEmpty) 0
    else list.maxBy(_.length).length
  }

  assert(solution(9) == 2)
  assert(solution(529) == 4)
  assert(solution(20) == 1)
  assert(solution(15) == 0)
  assert(solution(1041) == 5)

}
