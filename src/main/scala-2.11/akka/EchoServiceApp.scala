package akka

// Source - http://hseeberger.github.io/blog/2013/06/17/introduction-to-akka-i-slash-o/

import akka.actor._
import java.net.{InetSocketAddress, InetAddress}
import scala.io.StdIn._
import akka.io.{Tcp, IO}
import akka.io.Tcp._
import akka.io.Tcp.Connected
import akka.actor.Terminated
import akka.io.Tcp.Register
import akka.io.Tcp.Bind

object EchoServiceApp extends App {
  val system = ActorSystem("echo-service-system")
  val endpoint = new InetSocketAddress("localhost", 11111)
  system.actorOf(EchoService.props(endpoint), "echo-service")
  readLine(s"hit ENTER to exit... ${System.getProperty("line.separator")}")
  system.shutdown()
}

object EchoService {
  def props(endpoint: InetSocketAddress) = Props(new EchoService(endpoint))
}

class EchoService(endpoint: InetSocketAddress) extends Actor with ActorLogging{
  import context.system
  IO(Tcp) ! Bind(self, endpoint)

  def receive = {
    case Connected(remote, _) =>
      log.debug(s"Remote address ${remote} connected")
      sender ! Register(context.actorOf(EchoConnectionHandler.props(remote, sender)))
  }
}

object EchoConnectionHandler {
  def props(remote: InetSocketAddress, connection: ActorRef) = Props(new EchoConnectionHandler(remote, connection))
}

class EchoConnectionHandler(remote: InetSocketAddress, connection: ActorRef) extends Actor with ActorLogging {
  context.watch(connection)

  def receive = {
    case Tcp.Received(data) =>
      val text = data.utf8String.trim
      log.debug(s"received ${text} from remote address ${remote}")
      text match {
        case "close" => context stop self
        case _       => sender ! Write(data)
      }
    case _: Tcp.ConnectionClosed =>
      log.debug(s"stopping because connection for the remote address ${remote} closed")
      context stop self
    case Terminated(`connection`) =>
      log.debug(s"stopping because connection for the remote address ${remote} closed")
      context stop self
  }
}


