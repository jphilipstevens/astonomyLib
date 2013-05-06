package com.astro

import org.scalatest.FunSuite

/**
 * Test the right ascension model
 */
class RASuite extends FunSuite {
  
  var DECIMAL_PACES = 2
  
  
  test("can interpret ra string 18:30:23.1") {
    var ra = RightAscension("18:30:23.1");
    //we got here so no exception
    assert(true)
  }

  //bad hours range test
  test("string 25:30:23.1 throws an exception") {

    try {
      var ra = RightAscension("25:30:23.1");
      println("Results: " + ra.hours + " " + ra.minutes + " " + ra.seconds)
      //we got here this is bad
      assert(false)
    } catch {
      case ex: Exception => assert(true)
    }

  }

  test("string -1:18:23.1 throws an exception") {

    try {
      var ra = RightAscension("-1:30:23.1");
      //we got here this is bad
      assert(false)
    } catch {
      case ex: Exception => assert(true)
    }
  }

  //bad minutes range test
  test("string 18:-1:23.1 throws an exception") {

    try {
      var ra = RightAscension("18:-1:23.1");
      //we got here this is bad
      assert(false)
    } catch {
      case ex: Exception => assert(true)
    }

  }

  test("string 18:61:23.1 throws an exception") {

    try {
      var ra = RightAscension("18:61:23.1");
      //we got here this is bad
      assert(false)
    } catch {
      case ex: Exception => assert(true)
    }
  }

  //bad seconds range test
  test("string 18:30:-1 throws an exception") {

    try {
      var ra = RightAscension("18:30:-1");
      //we got here this is bad
      assert(false)
    } catch {
      case ex: Exception => assert(true)
    }

  }

  test("string 18:30:61 throws an exception") {

    try {
      var ra = RightAscension("18:30:61");
      //we got here this is bad
      assert(false)
    } catch {
      case ex: Exception => assert(true)
    }

  }

  test("RA 18:30:23.1 should evaluate to 277.6 degrees ") {

    var ra = RightAscension("18:30:23.10");
    var raDegrees = BigDecimal(ra.asDegrees()).setScale(DECIMAL_PACES, BigDecimal.RoundingMode.HALF_UP).toDouble
    assert(raDegrees == 277.6)
  }

  test("RA 18:30:23.1 should evaluate to 4.84 radians ") {

    var ra = RightAscension("18:30:23.10");
    println("RA 18.30.23.10 asRadians = " + ra.asRadians())
    var raRadians = BigDecimal(ra.asRadians()).setScale(DECIMAL_PACES, BigDecimal.RoundingMode.HALF_UP).toDouble
    assert(raRadians == 4.84)
  }

}