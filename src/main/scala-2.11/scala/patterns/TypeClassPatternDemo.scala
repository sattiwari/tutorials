/**
  * Created by stiwari on 8/31/2016 AD.
  */

/*
The idea of typeclasses is that you provide evidence(WrappedFoo) that a class (Wrapper) satisfies an interface(CanFoo).
Instead of Wrapper implement an interface directly, typeclasses let us split up defination of the class and the implementation of the interface
Source - http://www.cakesolutions.net/teamblogs/demystifying-implicits-and-typeclasses-in-scala
 */

object TypeClassPatternDemo extends App {
  trait CanFoo[A] {
    def foos(x: A): String
  }

  case class Wrapper(wrapped: String)

  implicit object WrapperCanFoo extends CanFoo[Wrapper] {
    def foos(x: Wrapper) = x.wrapped
  }

  def foo[A](thing: A)(implicit evidence: CanFoo[A]) = evidence.foos(thing)

  println(foo(Wrapper("hi")))
}