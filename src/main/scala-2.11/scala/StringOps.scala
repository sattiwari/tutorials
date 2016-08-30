package scala

import scala.annotation.tailrec

/**
  * Created by stiwari on 8/24/2016 AD.
  */
class StringOps(str: String) {

  def longestWord(str: String = str): String = {
    @tailrec
    def loop(words: List[String], longestWord: String): String = {
      if(words.isEmpty) longestWord
      else {
        if(longestWord.length > words.head.length) loop(words.tail, longestWord)
        else loop(words.tail, words.head)
      }
    }
    val words = str.split(" ").toList
    loop(words.tail, words.head)
  }

  def mostCommonWord(str: String = str): String = {
    val words = str.split(" ").toList
    words.groupBy(identity).mapValues(_.length).maxBy(_._2)._1
  }

  def mostCommonLetter(str: String = str): Char = {
    val words = str.split(" ").toList
    val letters = words.flatMap(_.toList)
    letters.groupBy(identity).mapValues(_.length).maxBy(_._2)._1
  }

  def letterToWordsMapping(str: String = str): Map[Char, Set[String]] = {
    val words = str.split(" ").toList
    val mapping = for {
      word <- words
      letter <- word
    } yield (letter -> word)
    mapping.groupBy(_._1).map{case (k,v) => (k -> v.map(_._2).toSet)}
  }

  def listOfStringtoAllCharsList(strings: List[String] = List(str)): List[Char] = {
    strings.flatMap(_.toList)
  }
}
