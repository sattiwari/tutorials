package tasks

/**
  * Created by stiwari on 2/11/2017 AD.
  */
object Task4 extends App {

  def solution(A: Array[Int]): Int = {
    var n: Int = A.length;
    var result: Int = 0;
    var i: Int = 0;
    while (i < n - 1) {
      if (A(i) == A(i + 1))
        result = result + 1;
      i = i + 1;
    }
    var r: Int = 0;
    i = 0;
    while (i < n && r <= 2) {
      var count: Int = 0;
      if (i > 0) {
        if ((A(i - 1) != A(i)))
          count = count + 1;
        else
          count = count - 1;
      }
      if (i < n - 1) {
        if (A(i + 1) != A(i))
          count = count + 1;
        else
          count = count - 1;
      }
      r = Math.max(r, count);
      i = i + 1;
    }
    return result + r;
  }


  solution(Array(0,1,0,1,0,1,0))

  assert(solution(Array(1, 1, 0, 1, 0, 0)) == 4)
  assert(solution(Array(1)) == 0)
  assert(solution(Array(1, 1)) == 1)
  assert(solution(Array(0)) == 0)
  assert(solution(Array(0, 0)) == 1)
  assert(solution(Array(1, 0)) == 1)
  assert(solution(Array(0, 1)) == 1)
  assert(solution(Array(1, 1, 0, 1)) == 3)
  assert(solution(Array(0,1,0)) == 2)
  assert(solution(Array(0,0,1,0,0)) == 4)
  assert(solution(Array(0,0,0,0,0)) == 4)
  assert(solution(Array(0,1,0,1,0,1,0)) == 2)
  assert(solution(Array(1,1,0,1,0,1,0)) == 3)
  assert(solution(Array.empty[Int]) == 0)

}
