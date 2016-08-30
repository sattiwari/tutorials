package scala

/**
  * Created by stiwari on 8/25/2016 AD.
  */
class OptionImp {
  def notNone(x: Option[Int], y: Option[Int], z: Option[Int]): Option[Int] = {
    if(!x.isDefined) x
    else if(!y.isDefined) y
    else if(!z.isDefined) z
    else None
  }
}
