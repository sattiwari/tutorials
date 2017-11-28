package leetCode

object SentenceSimilarity {
  def areSentencesSimilar(words1: Array[String], words2: Array[String], pairs: Array[Array[String]]): Boolean = {
    val pairTup = pairs.map(xs => (xs(0), xs(1)))
    if (words1.length != words2.length) false
    else {
      words1.zip(words2)
        .filterNot(t => t._1 == t._2)
        .forall{t =>
          pairTup.contains((t._1, t._2)) || pairTup.contains((t._2, t._1))
        }
    }
  }

  def main(args: Array[String]): Unit = {
    val x = areSentencesSimilar(Array("great","acting","skills"), Array("fine","drama","talent"),
      Array(Array("great","fine"), Array("drama","acting"), Array("skills","talent")))
    println(x)
  }
}