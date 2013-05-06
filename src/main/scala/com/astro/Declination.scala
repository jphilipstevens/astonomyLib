package com.astro

/**
 * Representation of Declination
 * From Wikipedia:
 * In astronomy, declination (abbreviated dec; symbol δ)
 * is one of the two angles that locate a point on the
 * celestial sphere in the equatorial coordinate system,
 * the other being hour angle. Declination's angle is
 * measured north or south of the celestial equator,
 * along the hour circle passing through the point in
 * question.[1]
 */
class Declination(val degreeHours: BigDecimal, val minutes: BigDecimal, val seconds: BigDecimal) {

  /**
   * get the degrees value of the RA
   */
  def asDegrees(): Double = {
    var degreesMin = (minutes / 60.0) * 15.0;
    var degreesSec = (seconds / 3600.0) * 15.0;
    var degreeVal = degreeHours + degreesMin + degreesSec;
    return degreeVal.toDouble
  }

  /**
   * Get the radians value of the RA
   */
  def asRadians(): Double = {
    var result = asDegrees()
    return Math.toRadians(result)
  }
}

/**
 * Helper Constructor for parsing args
 */
object Declination {
  def apply(decString: String) = {
    var raParts = decString.split(":").map(f => f.toDouble)
    if (raParts.length != 3) {
      throw new Exception("String is not in format hours:min:seconds")
    }

    //there has to be a more functional way to do this!
    //currently dont need to check degree range
    if (raParts(1) > 59 || raParts(1) < 0) {
      throw new Exception("minutes is beyond the normal rang of 0 - 59")
    }

    if (raParts(2) > 59 || raParts(2) < 0) {
      throw new Exception("seconds is beyond the normal rang of 0 - 59")
    }

    new Declination(raParts(0).toInt, raParts(1).toInt, raParts(2))
  }

}