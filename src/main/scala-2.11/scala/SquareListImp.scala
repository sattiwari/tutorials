package scala

/**
  * Created by stiwari on 8/25/2016 AD.
  */
class SquareListImp {
  def squareList(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => y*y :: squareList(ys)
  }

  def squareList2(xs: List[Int]): List[Int] =
    xs map {t => t * t}
}
