package reflect1

import scala.reflect.runtime.universe._
import scala.tools.reflect.ToolBox

object ScalaReflectDemo extends App {
  val tb = runtimeMirror(getClass.getClassLoader).mkToolBox()
  tb.eval(tb.parse("""println("hello")"""))
}
