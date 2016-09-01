package akkaExamples

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.scalalogging.LazyLogging

case class ComputeMessage(ts: List[(String, Int)])

class MapActor(reduceActor: ActorRef) extends Actor with LazyLogging {
  def tokenize(str: String) = str.split(" ").toList.map((_, 1))
  def receive = {
    case str: String =>
      logger.info("map actor received the message from the master");
      reduceActor ! ComputeMessage(tokenize(str))
  }
}

class ReduceActor(aggregateActor: ActorRef) extends Actor with LazyLogging{
  def compute(xs: List[(String, Int)]) = xs.groupBy(_._1).map{case (k,v) => (k, v.map(_._2).sum)}.toList
  def receive = {
    case ComputeMessage(xs) =>
      logger.info("Reduce actor received the message from the map actor");
      aggregateActor ! ComputeMessage(compute(xs))
  }
}

class AggregateActor extends Actor with LazyLogging {
  def compute(xs: List[(String, Int)]) = xs.groupBy(_._1).map{case (k,v) => (k, v.map(_._2).sum)}
  def receive = {
    case ComputeMessage(xs) =>
      logger.info("aggregate actor received the message from master");
      val result = compute(xs)
      logger.info("final result is")
      result.foreach{t => logger.info(t.toString)}
      context.system.shutdown()
  }
}

class MasterActor extends Actor with LazyLogging{
  val aggregateActor = context.system.actorOf(Props[AggregateActor], name = "aggregate-actor")
  val reduceActor = context.system.actorOf(Props(new ReduceActor(aggregateActor)), name = "reduce-actor")
  val mapActor = context.system.actorOf(Props(new MapActor(reduceActor)), name = "map-actor")

  def receive: Receive = {
    case message: String =>
      logger.info("master received message from the main program");
      mapActor ! message
  }
}

object WordCountAkka extends App with LazyLogging{
  logger.info("main application is running")
  val system = ActorSystem("word-count")
  val master = system.actorOf(Props[MasterActor], name = "master")

  master ! "Satendra is a great great coder Satendra lives in Bangkok Bangkok has many coder s"
}
