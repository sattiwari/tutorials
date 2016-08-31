package scala.random

/**
  * Created by stiwari on 8/31/2016 AD.
  */
object ListOps extends App{
  val list = List(("a", 1), ("a", 2), ("b", 1))
  list.groupBy(_._1).map{case (k,v) => (k, v.map(_._2).sum)}
}
