package javatime

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object JavaTimeDemo extends App {

  def getIndexName(bookingDate: ZonedDateTime): String = {
    val format        = DateTimeFormatter.ofPattern("YYYY.MM.dd")
    val datePartition = format.format(bookingDate)

    datePartition
  }


}
