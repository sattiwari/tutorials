package reports

import com.typesafe.config.ConfigFactory
import reports.Parser.getClass

import scala.io.Source
import scala.util.Try
import scala.collection.mutable

object Parser extends App {

  val stream = getClass.getResourceAsStream("/nbd2015.txt")
  val records = Source.fromInputStream(stream).getLines().toList

  records.foreach { rec =>
    val str = rec.takeWhile(t => t.isLetter || t == ' ')
    val ts = rec.split(" ")
    val nums = ts.takeRight(3)
    val y2015 = Try{nums(1)}.getOrElse(0)
    val y2014 = Try{nums(2)}.getOrElse(0)
    println(s"${str} ${y2015} ${y2014}")
  }

}

object MashreqParser extends App {

  val years = List(2016, 2015)

  val stats = mutable.Map[String, List[String]]()

  years.foreach { year =>
    val stream = getClass.getResourceAsStream(s"/mashreq/${year}")
    val records = Source.fromInputStream(stream).getLines().toList

    records.foreach { rec =>
      val str = rec.takeWhile(t => t.isLetter || t == ' ').trim
      val ts = rec.split(" ")
      val nums = ts.takeRight(4)
      val data = nums(0)

      if(stats.contains(str)) {
        val existing = stats(str)
        val updatedValues = existing ++ List(data)
        stats.update(str, updatedValues)
      } else {
        stats.update(str, List(data))
      }
      s"${str.trim} ${data}"
    }
  }

  stats.foreach { r =>
    println(s"${r._1} ${r._2.mkString(" ")}")
  }

}

object MashreqParser2 extends App {

  val stream = getClass.getResourceAsStream("/mashreq/2008")
  val records = Source.fromInputStream(stream).getLines().toList

  records.foreach { rec =>
    val str = rec.takeWhile(t => t.isLetter || t == ' ')
    val ts = rec.split(" ")
    val nums = ts.takeRight(4)
    println(nums(2))
  }

}

object NBADParser extends App {
  val stream = getClass.getResourceAsStream("/nbad/2008")
  val records = Source.fromInputStream(stream).getLines().toList

  records.foreach { rec =>
    val str = rec.takeWhile(t => t.isLetter || t == ' ').trim
    val ts = rec.split(" ")
    val nums = ts.takeRight(4)
    println(s"${nums(1)}")
  }
}

object RakBankParser extends App {
  val stream = getClass.getResourceAsStream("/rakbank/2008")
  val records = Source.fromInputStream(stream).getLines().toList

  records.foreach { rec =>
    val str = rec.takeWhile(t => t.isLetter || t == ' ').trim
    val ts = rec.split(" ")
    val nums = ts.takeRight(2)
    println(nums(1))
  }
}


object UnbParser extends App {
  val stream = getClass.getResourceAsStream("/unb/2008")
  val records = Source.fromInputStream(stream).getLines().toList

  records.foreach { rec =>
    val str = rec.takeWhile(t => t.isLetter || t == ' ').trim
    val ts = rec.split(" ")
    val nums = ts.takeRight(4)
//    println(nums(0))
    println(s"${str};${nums(0)};${nums(1)}")
  }
}

object UabParser extends App {
  val stream = getClass.getResourceAsStream("/uab/2015")
  val records = Source.fromInputStream(stream).getLines().toList

  records.foreach { rec =>
    val str = rec.takeWhile(t => t.isLetter || t == ' ').trim
    val ts = rec.split(" ")
    val nums = ts.takeRight(2)
//        println(nums(0))
    println(s"${str};${nums(0)};${nums(1)}")
  }
}
