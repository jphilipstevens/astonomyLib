package com.astro

/**
 * A representation of Right Ascention
 * From Wikipedia:
 *
 * Right ascension (abbreviated RA; symbol α) is the astronomical
 * term for one of the two direction coordinates of a point on the
 * celestial sphere in the equatorial coordinate system, usually
 * combined with declination. Right ascension's angular distance
 * is measured eastward along the celestial equator from the vernal
 * equinox to the hour circle of the point in question.[1]
 */
class RightAscension(val hours: Double, val minutes: Double, val seconds: Double) {

  /**
   * get the degrees value of the RA
   */
  def asDegrees(): Double = {
    var degreeHours = hours * 15.0;
    var degreesMin = (minutes / 60.0) * 15.0;
    var degreesSec = (seconds / 3600.0) * 15.0;
    var degrees = degreeHours + degreesMin + degreesSec;
    return degrees
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
    println(raString)
    var raParts = raString.split(":").map(f => f.toDouble)
    if (raParts.length != 3) {
      throw new Exception("String is not in format hours:min:seconds")
    }
    raParts.map(f => println("\t\t" + f))
    //there has to be a more functional way to do this!
    if (raParts(0) > 24 || raParts(0) < 0) {
      throw new Exception("hours is beyond the normal range of 0 - 24")
    }

    if (raParts(1) > 59 || raParts(1) < 0) {
      throw new Exception("minutes is beyond the normal range of 0 - 59")
    }

    if (raParts(2) > 59 || raParts(2) < 0) {
      throw new Exception("seconds is beyond the normal range of 0 - 59")
    }

    new RightAscension(raParts(0), raParts(1), raParts(2))
  }
}
