package scala

/**
  * Created by stiwari on 8/25/2016 AD.
  */
class VectorOps(numbers: Vector[Int]) {
  lazy val square = numbers map (t => t*t)
  lazy val sum = numbers.foldLeft(0)(_ + _) //why numbers foldLeft(0)(_ + _) doesnt work?
  lazy val sqrt = Math.sqrt(sum)
}
