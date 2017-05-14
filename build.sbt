name := "tutorials"

version := "1.0"

scalaVersion := "2.11.8"

val dependecies = Seq("org.scalatest" % "scalatest_2.11" % "2.2.2",
  "org.apache.spark" % "spark-core_2.11" % "1.3.0",
  "org.apache.hadoop" % "hadoop-hdfs" % "2.7.3",
  "ch.qos.logback" %  "logback-classic" % "1.1.7",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
  "io.spray" % "spray-can_2.11" % "1.3.1",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "com.madhukaraphatak" %% "java-sizeof" % "0.1",
  "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8",
  "com.typesafe.akka" %% "akka-cluster-sharding" % "2.5.1",
  "com.google.guava"            %   "guava"                              %   "20.0")

libraryDependencies ++= dependecies

resolvers += "spray repo" at "http://repo.spray.io/"