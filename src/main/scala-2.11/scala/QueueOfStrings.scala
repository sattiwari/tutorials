package scala

import scala.collection.mutable.ArrayBuffer

/**
  * Created by stiwari on 8/24/2016 AD.
  */
trait Queue[A] {
  def put(item: A)
  def get: Option[A]
}

class QueueOfStrImp extends Queue[String] {
  var items = new ArrayBuffer[String]()

  def put(item: String) = items += item
  def get = if(items.isEmpty) None else Some(items.remove(0))
}

trait Reverse extends QueueOfStrImp {
  abstract override def put(item: String) { super.put(item.reverse)}
}

class QueueOfStringsImp2 extends QueueOfStrImp with Reverse