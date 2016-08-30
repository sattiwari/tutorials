package scala

/**
  * Created by stiwari on 8/25/2016 AD.
  */
trait Utils {
  def timeit[T](block: => T): T = {
    val start = System.currentTimeMillis()
    val result = block
    val end = System.currentTimeMillis()
    println(s"Execution took ${end - start} milliseconds")
    result
  }

  def retry[T](block: => T)(implicit count: Int): Unit = {
    (1 to count).foreach{ i =>
      val res = block
      println(s"${i} execution result is ${res}")
      Thread.sleep(1000)
    }
  }
}

object TimeUtils extends App with Utils{
  val obj = GCD
  println(timeit[Int](obj.calGCD(178378794, 787872221)))
}

object RetryUtils extends App with Utils{
  val obj = GCD
  implicit val retryCount = 3
  retry[Int](obj.calGCD(178378794, 787872221))
}
