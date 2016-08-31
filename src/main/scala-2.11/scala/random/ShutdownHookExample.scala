package scala.random

/**
  * Created by stiwari on 8/31/2016 AD.
  */
object ShutdownHookExample extends App {
  Runtime.getRuntime.addShutdownHook(new Thread() {
    override def run() = {
      println("this gets executed before jvm goes down")
    }
  })
}
