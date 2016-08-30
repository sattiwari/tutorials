package scala

import scala.annotation.tailrec

/**
  * Created by stiwari on 8/24/2016 AD.
  */
object GCD {

  @tailrec
  final def calGCD(a: Int, b: Int): Int = {
    (a,b) match {
      case (_, 0) => a
      case _      => calGCD(b, a%b)
    }
  }
}
