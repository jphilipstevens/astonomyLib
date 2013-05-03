package com.astro

/**
 * Represents a "target" which can be anything from a region in the sky to an actual object
 */
class Target(val rightAscention: RightAscension, val declination: Declination) {

  /**
   * Convenience constructor
   *  @constructor this will parse the strings for you!
   *  @param raString
   *  @param decString
   */
  def this(raString: String, decString: String) = {
    this(RightAscension(raString), Declination(decString))
  }

  /**
   * Get the angular distance between two celectial points
   * @param that the target we want to get the distance of
   * @param asDegrees true will return the value as a degree value, false will return it as a radians value
   */
  def distance(that: Target, asDegrees: Boolean): Double = {
    var cosGamma = Math.cos(90 - rightAscention.asDegrees) * Math.cos(90 - that.rightAscention.asDegrees) + Math.sin(90 - rightAscention.asDegrees) * Math.sin(90 - that.rightAscention.asDegrees) * Math.cos(declination.asDegrees - that.declination.asDegrees)
    if (!asDegrees) {
      return Math.acos(cosGamma)
    } else {
      return Math.toDegrees(Math.acos(cosGamma))
    }
  }
}