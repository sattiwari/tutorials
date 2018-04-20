package random

object NestedList extends App {

  val xs = List(1, 2, 3, 4, 5)

  case class NestedList(elem: Int, sublist: List[Int])

  def toSublist(xs: List[Int]): List[Any] = {
    xs match {
      case Nil =>
        println("empty list")
        Nil
      case h :: Nil =>
        println("single element list")
        List(h, Nil)
      case h :: t =>
        println("multi element list")
        List(h, toSublist(t))
    }
  }

  println(toSublist(xs))

}
