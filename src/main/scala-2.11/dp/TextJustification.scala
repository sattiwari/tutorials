package dp

object TextJustification extends App {

  def solution(words: List[String], width: Int) = {
    val numList = words.map(_.length)
    numList.foreach(println)
  }

  solution(List("this","is","an","example","of","text", "justification"), 16)

}
