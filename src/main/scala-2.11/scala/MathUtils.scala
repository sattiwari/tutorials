package scala

/**
  * Created by stiwari on 8/25/2016 AD.
  */

object MathUtils extends App {
  implicit class DoubleImprovements(x: Double) {
    def ~=(y: Double)(implicit precision: Double) = (x - y).abs < precision
  }

  implicit class SequenceImprovements[T](xs: Seq[T]) {
    def median(f: (T,T) => Boolean) = {
      val len  = xs.length
      val sorted = xs.sortWith(f)
      sorted(len/2)
    }
  }
}




