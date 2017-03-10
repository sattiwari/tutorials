package scala

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

/**
  * Created by stiwari on 2/17/2017 AD.
  */
object FutureDemo extends App {

  val x = Future((1 to 100000000).foldLeft(0)(_ + _)).map(x => x + 1)
  val y = Await.result(x, 10 seconds)
  println(y)

}
