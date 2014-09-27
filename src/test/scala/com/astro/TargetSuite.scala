package com.astro

import org.scalatest.FunSuite

class TargetSuite extends FunSuite {

  val DECIMAL_PACES = 2

  test("Target(07 49 58, -40 11 42) and Target(06 31 20, -56 10 19) are 18.7971 degrees apart") {
    val tar1 = new Target("07:49:58", "-40:11:42")
    val tar2 = new Target("06:31:20", "-56:10:19")
    println("Target(07 49 58, -40 11 42) - Target(06 31 20, -56 10 19) distance is " + tar1.distance(tar2, true))
    val targetDistance = BigDecimal(tar1.distance(tar2, true)).setScale(DECIMAL_PACES, BigDecimal.RoundingMode.HALF_UP).toDouble

    assert(targetDistance == 18.7971)
  }
}