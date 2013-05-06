package com.astro

import org.scalatest.FunSuite
/**
 * Test the right Declenation model
 */
class DecSuite extends FunSuite {
  var DECIMAL_PACES = 2

  test("can interpret Dec string 18:30:23.1") {
    var dec = Declination("18:30:23.1");
    //we got here so no exception
    assert(true)
  }

  //bad minutes range test
  test("string 18:-1:23.1 throws an exception") {

    try {
      var dec = Declination("18:-1:23.1");
      //we got here this is bad
      assert(false)
    } catch {
      case ex: Exception => assert(true)
    }
  }

  test("string 18:61:23.1 throws an exception") {

    try {
      var dec = Declination("18:61:23.1");
      //we got here this is bad
      assert(false)
    } catch {
      case ex: Exception => assert(true)
    }
  }

  //bad seconds range test
  test("string 18:30:-1 throws an exception") {

    try {
      var dec = Declination("18:30:-1");
      //we got here this is bad
      assert(false)
    } catch {
      case ex: Exception => assert(true)
    }
  }

  test("string 18:30:61 throws an exception") {

    try {
      var dec = Declination("18:30:61");
      //we got here this is bad
      assert(false)
    } catch {
      case ex: Exception => assert(true)
    }
  }

  test("Dec 18:30:23.1 should evaluate to 25.6 degrees ") {

    var dec = Declination("18:30:23.10");
    var decDegrees = BigDecimal(dec.asDegrees()).setScale(DECIMAL_PACES, BigDecimal.RoundingMode.HALF_UP).toDouble
    assert(decDegrees == 25.6)
  }

  test("Dec 18:30:23.1 should evaluate to 0.45 radians ") {
    var dec = Declination("18:30:23.10");
    println("Dec 18.30.23.10 asRadians = " + dec.asRadians())
    var decRadians = BigDecimal(dec.asRadians()).setScale(DECIMAL_PACES, BigDecimal.RoundingMode.HALF_UP).toDouble
    assert(decRadians == 0.45)
  }

}