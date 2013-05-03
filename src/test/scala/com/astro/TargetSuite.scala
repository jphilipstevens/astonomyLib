package com.astro

import org.scalatest.FunSuite

/**
 * Unit test for targets
 */
class TargetSuite extends FunSuite {

  /**
   * Test that 2 targets are at the correct angular distance
   */
  test("Target(07 49 58, -40 11 42) and Target(06 31 20, -56 10 19) are 20.51382 degrees apart") {
    var tar1 = new Target("07:49:58", "-40:11:42")
    var tar2 = new Target("06:31:20", "-56:10:19")
    println("Target(07 49 58, -40 11 42) - Target(06 31 20, -56 10 19) distance is " + tar1.distance(tar2, true))
    assert(tar1.distance(tar2, true) == 20.51382)
  }
}