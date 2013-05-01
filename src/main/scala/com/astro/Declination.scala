package com.astro

class Declination(degrees: Int, minutes: Int, seconds: Double) {

}

object Declination {
  def apply(decString: String) = {
    println("constructing object")
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