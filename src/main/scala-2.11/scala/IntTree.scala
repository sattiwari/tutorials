package scala

abstract class IntTree {
  def contains(t: IntTree, v: Int): Boolean = t match {
    case EmptyTree => false
    case Node(elem, left, right) => contains(left, elem) || contains(right, elem)
  }

  def insert(t: IntTree, v: Int): IntTree = t match {
    case EmptyTree => Node(v, EmptyTree, EmptyTree)
    case Node(elem, left, right) => if(v < elem) insert(left, v) else insert(right, v)
  }
}

case object EmptyTree extends IntTree
case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree