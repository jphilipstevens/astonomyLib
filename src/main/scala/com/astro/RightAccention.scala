package com.astro

class RightAccention(hours: Int, minutes: Int, seconds: Double) {

  def asDegrees(): Double = {
    var result = 0.0
    
    return 0.0
  }
}

object RightAccention {
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

    new RightAccention(raParts(0).toInt, raParts(1).toInt, raParts(2))
  }
}
