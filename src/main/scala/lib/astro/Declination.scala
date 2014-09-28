package lib.astro

import scala.util.Try

object Declination {

  object DeclinationStringPosition {
    val degrees = 0
    val minutes = 1
    val seconds = 2
  }

  def apply(parsableDeclination: String): Try[Declination] = Try({
    val declinationElements = parsableDeclination.split(":")
    new Declination(declinationElements(DeclinationStringPosition.degrees).toInt, declinationElements(DeclinationStringPosition.minutes).toInt, BigDecimal(declinationElements(DeclinationStringPosition.seconds)))
  })
}

case class Declination(degrees: Int, minutes: Int, seconds: BigDecimal) {
  require(minutes >= 0 && minutes <= 60)
}
