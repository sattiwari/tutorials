package akkaExamples

import akka.actor.{Actor, ActorSystem, Props}
import akka.io.IO
import akka.io.Tcp.Connected
import spray.can.Http
import spray.can.Http._
import spray.http.{HttpRequest, HttpResponse}
import spray.http.HttpMethods.GET

import scala.io.StdIn._

/**
  * Created by stiwari on 9/1/2016 AD.
  */
object HttpExample extends App {
  val system = ActorSystem("system")
  val (host, port) = ("localhost", 8080)
  system.actorOf(HTTPListener.props(host, port))
  readLine("press any key to exit")
  system.shutdown()
}

object HTTPListener {
  def props(host: String, port: Int) = Props(new HTTPListener(host, port))
}

class HTTPListener(host: String, port: Int) extends Actor {
  import context.system
  IO(Http) ! Bind(self, host, port)

  def receive = {
    case Connected(remote, _) =>
      sender ! Http.Register(context.actorOf(Props(new HTTPConnectionHandler)))
  }
}

class HTTPConnectionHandler extends Actor {

  def receive = {
    case HttpRequest(GET, uri, _, _, _) =>
      sender ! HttpResponse(entity = uri.path.toString())
  }
}