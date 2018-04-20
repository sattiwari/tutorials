package scalar2018

object MathUtils {

  def mean(xs: Seq[Long]): Double = xs match {
    case Nil => 0.0
    case ys  => ys.sum / ys.size.toDouble
  }

  def sd(xs: Seq[Long], avg: Double): Double = xs match {
    case Nil => 0.0
    case ys  => math.sqrt((0.0 /: ys) {
      (a, e) => a + math.pow(e - avg, 2.0)
    } / xs.size)
  }

  def ema(currentMean: Double, recordedValue: Double, weight: Double): Double =
    (1 - weight) * currentMean + weight * recordedValue

  def ems(currentMean: Double, currentSd: Double, recordedValue: Double, weight: Double): Double =
    Math.sqrt((1 - weight) * Math.pow(currentSd, 2) + weight * Math.pow(recordedValue - currentMean, 2))

}
