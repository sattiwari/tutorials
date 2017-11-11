package scala.talks.mar2009

import java.io.{BufferedReader, FileReader}

object ControlStructureDemo extends App {

  def using[T <: {def close()}](resource: T)(block: T => Unit): Unit = {
    try {
      block(resource)
    } finally {
      if(resource != null) resource.close()
    }
  }

  using(new BufferedReader(new FileReader("/tmp/hello"))) {
    f => println(f.readLine())
  }

}
