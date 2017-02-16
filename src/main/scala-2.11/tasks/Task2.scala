package tasks

/**
  * Created by stiwari on 2/11/2017 AD.
  */
object Task2 extends App {

  def solution(a: Int, b: Int): Int = {
    (a to b)
      .filter(i => (Math.sqrt(i) - Math.sqrt(i).round) == 0)
      .length
  }

  assert(solution(4, 17) == 3)
  assert(solution(4, 4) == 1)
  assert(solution(17, 17) == 0)


}
