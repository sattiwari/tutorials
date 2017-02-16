package tasks

object Task1 extends App {

  private def hasUpperCase(s: String) = s.filter(_.isUpper).length > 0

  def solution(s: String): Int = {
    if(!hasUpperCase(s)) -1
    else {
      s.split("(?<=\\D)(?=\\d)")
        .filter(hasUpperCase)
        .map(s => s.filterNot(_.isDigit).length)
        .max
    }
  }

  assert(solution("a0bb") == -1)
  assert(solution("a0Ba") == 2)
  assert(solution("aaaaaaaa") == -1)
  assert(solution("aaaaaaaaA") == 9)
  assert(solution("aaaaaaaa0A") == 1)


}
