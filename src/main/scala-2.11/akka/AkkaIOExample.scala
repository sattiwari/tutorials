package akka

import akka.io.{IO, Tcp}
import akka.actor.{ActorRef, Actor}
import akka.io.Tcp._
import java.net.InetSocketAddress
import akka.util.ByteString
import akka.io.Tcp.Connected
import akka.io.Tcp.Register
import akka.io.Tcp.Connect
import akka.io.Tcp.CommandFailed

/*
Source - http://doc.akka.io/docs/akka/snapshot/scala/io-tcp.html
 */

//class Client(remote: InetSocketAddress, listener: ActorRef) extends Actor{
//  IO(Tcp) ! Connect(remote)
//
//  def receive = {
//    case CommandFailed(_: Connect) =>
//      listener ! "connect failed"
//      context.stop(self)
//    case c @ Connected(remote, local) =>
//      listener ! c
//      val connection = sender()
//      connection ! Register(self)
//      context become {
//        case data: ByteString =>
//          connection ! Write(data)
//        case CommandFailed(w: Write) =>
//          listener ! "Write failed"
//        case Received(data) =>
//          listener ! data
//        case "close" =>
//          connection ! Close
//        case _: ConnectionClosed =>
//          listener ! "connection closed"
//          context stop self
//      }
//  }
//}
//
//class Server extends Actor {
//  IO(Tcp) ! Bind(self, new InetSocketAddress("localhost", 0))
//
//  def receive = {
//    case b @ Bound(localAddress) => println("binding successful")
//    case CommandFailed(_: Bind) => context stop self
//    case c @ Connected(remote, local) =>
//
//
//  }
//}
//
//class SimplisticHandler extends Actor {
//  def receive = {
//    case Received(data) => sender ! Write(data)
//    case PeerClosed     => context stop self
//  }
//}