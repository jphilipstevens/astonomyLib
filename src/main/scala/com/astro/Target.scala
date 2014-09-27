package com.astro

class Target(val rightAscention: RightAscension, val declination: Declination) {

  def this(raString: String, decString: String) = {
    this(RightAscension(raString), Declination(decString))
  }

  def distance(that: Target, asDegrees: Boolean): Double = {
    import java.lang.Math._

    val t = sin(this.declination.asRadians) * sin(that.declination.asRadians) +
      cos(this.declination.asRadians) *
      cos(that.declination.asRadians) *
      cos((((this.rightAscention.asRadians() - that.rightAscention.asRadians()))))

    asDegrees match {
      case true => Math.toDegrees(Math.acos(t))
      case false => t
    }
  }
}