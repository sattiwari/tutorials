package hackerrank

/**
  * Created by stiwari on 5/4/2017 AD.
  */
object Utils {

  def getPairs(a: Set[Int]) = {
    val len = a.size
    for {
      (i, j) <- a.zipWithIndex
      k <- a.takeRight(len - j)
    } yield (i, k)

  }

}
