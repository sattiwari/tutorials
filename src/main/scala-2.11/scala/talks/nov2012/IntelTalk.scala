package scala.talks.nov2012

object IntelTalk extends App {

  val data = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  def cluster[T](xs: List[T]): List[List[T]] = {
    xs match {
      case Nil => Nil
      case y :: ys =>
        val (first, rest) = xs span (_ == y)
        first :: cluster(rest)
    }
  }

  def encode[T](xs: List[T]): List[(T, Int)] =
    cluster(xs) map (ys => (ys.head, ys.length))

  println(encode(data))

}
