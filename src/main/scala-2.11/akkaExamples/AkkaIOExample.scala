package akkaExamples

import java.net.InetSocketAddress

import akka.actor.{Actor, ActorSystem, Props}
import akka.io.Tcp.{Connected, Register, _}
import akka.io.{IO, Tcp}

import scala.io.StdIn._

object AkkaIOExample extends App {
  val system = ActorSystem("system")
  val address = new InetSocketAddress("localhost", 11111)
  val listener = system.actorOf(Listener.props(address), "listener")
  readLine("press any key to exit")
  system.shutdown()
}

object Listener {
  def props(address: InetSocketAddress) = Props(new Listener(address))
}

class Listener(address: InetSocketAddress) extends Actor {
  import context.system

  IO(Tcp) ! Bind(self, address)

  def receive = {
    case Connected(remote, _) =>
      sender ! Register(context.actorOf(ConnectionHandler.props(remote)))
  }
}

object ConnectionHandler {
  def props(address: InetSocketAddress) = Props(new ConnectionHandler(address))
}

class ConnectionHandler(address: InetSocketAddress) extends Actor {
  def receive = {
    case Received(data) =>
      val text = data.utf8String.trim
      if(text == "stop") context.stop(self)
      else sender ! Write(data)
  }
}