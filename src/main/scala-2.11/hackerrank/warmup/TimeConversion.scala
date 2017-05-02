package hackerrank.warmup

/**
  * Created by stiwari on 5/3/2017 AD.
  */
object TimeConversion {

//  07:05:45PM
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var time = sc.next();

    val t = time.split(":")
    val (hr, min, sec, am) = (t(0), t(1), t(2).take(2), t(2).takeRight(2) == "AM")
    val hrInt = hr.toInt

    val res = if(am) {
      if(hrInt == 12) s"00:$min:$sec"
      else s"$hr:$min:$sec"
    } else {
      if(hrInt == 12) s"12:$min:$sec"
      else s"${hrInt+12}:$min:$sec"
    }

    println(res)
  }

}
