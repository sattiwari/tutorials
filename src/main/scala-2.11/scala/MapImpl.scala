package scala

/**
  * Created by stiwari on 8/25/2016 AD.
  */
class MapImpl {
  def multiply(list: List[Int], map: Map[Int, Double]) = {
    list.flatMap { case elem =>
      val value = map.get(elem)
      value match {
        case Some(num) => Some(num * elem)
        case _ => None
      }
    }
  }
}
