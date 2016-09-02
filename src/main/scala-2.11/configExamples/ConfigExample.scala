package configExamples

import com.typesafe.config.ConfigFactory


object ConfigExample extends App{
  val conf = ConfigFactory.load()
  val bar1 = conf.getInt("foo.bar")
  val foo = conf.getConfig("foo")
  val bar = foo.getInt("bar")
  println(bar, bar1)
}
