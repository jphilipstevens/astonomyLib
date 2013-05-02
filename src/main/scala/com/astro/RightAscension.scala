package com.astro

/**
 * 
 */
class RightAscension private (hours: Double, minutes: Double, seconds: Double) {

  /**
   * get the degrees value of the RA
   */
  def asDegrees(): Double = {
    var result = 0.0
    var degreeHours = hours * 15.0;
    var degreesMin = (minutes / 60.0) * 15.0;
    var degreesSec = (seconds / 3600.0) * 15.0;
    var degrees = degreeHours + degreesMin + degreesSec;
    return result
  }

  /**
   * Get the radians value of the RA
   */
  def asRadians(): Double = {
    var result = asDegrees()

    return Math.toRadians(result)
  }
}

object RightAscension {
  /**
   * Parse the RA string which should be in hours:minutes:seconds
   */
  def apply(raString: String) = {
    println("constructing object")
    var raParts = raString.split(":").map(f => f.toDouble)
    if (raParts.length != 3) {
      throw new Exception("String is not in format hours:min:seconds")
    }

    //there has to be a more functional way to do this!
    if (raParts(0) > 24 || raParts(0) < 0) {
      throw new Exception("hours is beyond the normal rang of 0 - 24")
    }

    if (raParts(1) > 59 || raParts(1) < 0) {
      throw new Exception("minutes is beyond the normal rang of 0 - 59")
    }

    if (raParts(2) > 59 || raParts(2) < 0) {
      throw new Exception("seconds is beyond the normal rang of 0 - 59")
    }

    new RightAscension(raParts(0), raParts(1), raParts(2))
  }

  def apply(hours: Int, minutes: Int, seconds: Double) = {
    new RightAscension(Double.box(hours), Double.box(minutes), seconds)
  }
}
