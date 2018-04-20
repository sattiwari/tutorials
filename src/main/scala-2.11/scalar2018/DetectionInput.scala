package scalar2018

import org.joda.time.DateTime

case class ModelKey(weekDay: Int, hour: Int, minute: Int, dimensions: Seq[DimensionValue])

case class Model(mean: Double, sd: Double) {

  def learn(adaptedValue: Double, modelWeight: Double): Model = {
    Model(MathUtils.ema(mean, adaptedValue, modelWeight), MathUtils.ems(mean, sd, adaptedValue, modelWeight))
  }

}

object Model {

  private val InitialSd = 0.0

//  def apply(detectionInput: Seq[DetectionInput], modelOutliersPercentile: Double): Model = {
//    val counts = detectionInput.map(_.count)
//    val emaMeanBeforeNormalization = MathUtils.mean(counts)
//
//  }

}

case class DimensionValue()
case class DetectionInput(utcTimestamp: DateTime, serviceIdTimestamp: DateTime, dimensions: Seq[DimensionValue], count: Long) {
  val x = serviceIdTimestamp.getDayOfWeek
  val y = serviceIdTimestamp.getHourOfDay
  val z = serviceIdTimestamp.getMinuteOfHour
}
