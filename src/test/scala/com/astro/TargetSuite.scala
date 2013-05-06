package com.astro

import org.scalatest.FunSuite

/**
 * Unit test for targets
 */
class TargetSuite extends FunSuite {
  
  var DECIMAL_PACES = 2
  
  /**
   * Test that 2 targets are at the correct angular distance
   */
  test("Target(07 49 58, -40 11 42) and Target(06 31 20, -56 10 19) are 2.13 degrees apart") {
    var tar1 = new Target("07:49:58", "-40:11:42")
    var tar2 = new Target("06:31:20", "-56:10:19")
    println("Target(07 49 58, -40 11 42) - Target(06 31 20, -56 10 19) distance is " + tar1.distance(tar2, true))
    var targetDistance = BigDecimal(tar1.distance(tar2, true)).setScale(DECIMAL_PACES, BigDecimal.RoundingMode.HALF_UP).toDouble

    assert(targetDistance == 2.13)
  }
}