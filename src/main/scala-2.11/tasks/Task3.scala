package tasks

/**
  * Created by stiwari on 2/11/2017 AD.
  */
object Task3 extends App {

  private def getEncodedString(s: String) = {
    s.flatMap { c =>
      if (c.isDigit) List.fill(c.toInt - 48)('?')
      else List(c)
    }
  }

  def solution(s: String, t: String): Boolean = {
    val (s1, t1) = (getEncodedString(s), getEncodedString(t))

    if(s1.length != t1.length) false
    else s1.zip(t1).filterNot{case (c1, c2) => ((c1 == '?' || c2 == '?') || (c1 == c2))}.length == 0
  }

  assert(solution("A2Le", "2pL1") == true)
  assert(solution("a10", "10a") == true)
  assert(solution("ba1", "1Ad") == false)
  assert(solution("3x2x", "8") == false)
  assert(solution("sa6", "satendra") == true)

}
