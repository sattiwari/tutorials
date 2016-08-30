package scala

/**
  * Created by stiwari on 8/25/2016 AD.
  */
trait IntSet {
  def isEmpty: Boolean
  def incl(x: Int): IntSet
  def excl(x: Int): Option[IntSet]
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
  def intersection(other: IntSet): IntSet
}

class EmptySet extends IntSet {
  def isEmpty = true
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmptySet(x, new EmptySet, new EmptySet)
  def union(other: IntSet): IntSet = other
  def intersection(other: IntSet): IntSet = this
  def excl(x: Int): Option[IntSet] = None
}

class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def isEmpty = false

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this

  def union(other: IntSet): IntSet = {
    (((left union right) union other) incl elem)
  }

  def intersection(other: IntSet): IntSet = {
    val l = left intersection other
    val r = right intersection other
    val s = l union r
    if(other contains elem) s incl elem else s
  }

  def excl(x: Int): Option[IntSet] = {
    if(x == elem) Some(left union right)
    else if(x < elem) left excl x
    else right excl x
  }
}