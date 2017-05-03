package hackerrank.implementation

/**
  * Created by stiwari on 5/4/2017 AD.
  */
object DayOfProgrammer {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var year = sc.nextInt();

    val g = year >= 1918
    val leap = {
      if(g) ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
      else year % 4 == 0
    }

    if(year == 1918) println("26.09.1918")
    else if(leap) println(s"12.09.$year")
    else println(s"13.09.$year")

  }

}
