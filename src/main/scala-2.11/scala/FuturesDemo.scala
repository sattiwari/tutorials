package scala

import java.util.concurrent.Executor

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future, blocking}

object FuturesDemo {

//  the following code uses 32K threads
  for( i <- 1 to 32000 ) {
    Future {
      blocking {
        Thread.sleep(999999)
      }
    }
  }

  val currentThreadExecutionContext = ExecutionContext.fromExecutor(
    new Executor {
      // Do not do this!
      def execute(runnable: Runnable) { runnable.run() }
    })






}
