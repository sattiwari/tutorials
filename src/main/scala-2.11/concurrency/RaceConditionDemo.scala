package concurrency

import java.util.concurrent.atomic.AtomicInteger

/*
In race condition, the program's output depends on the order of execution
 */
object RaceConditionDemo extends App {

  var uniqueID = 0
  val atomicID = new AtomicInteger(0)

  def log(s: Any) = println(s"${Thread.currentThread().getName} ${s}")

  def thread(n: Int): Thread = new Thread() {
    override def run(): Unit = {
      printUniqueIds(n)
    }
  }

  def printUniqueIds(n: Int): Unit = {
    val ids = for (i <- (0 until n)) yield (correctGetId)
    log(ids)
  }

  def correctGetId = {
    this.synchronized {
      val freshID = uniqueID + 1
      uniqueID = freshID
      freshID
    }
  }

  def wrongGetId = {
    val freshID = uniqueID + 1
    uniqueID = freshID
    freshID
  }

  val t = thread(5)
  t.start()

  printUniqueIds(5)
  t.join()

}
