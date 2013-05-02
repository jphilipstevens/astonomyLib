package com.astro

import org.scalatest.FunSuite

/**
 * Test the right ascension model
 */
class RASuite extends FunSuite {
  test("can interpret ra string 18:30:23.1") {
    var ra = RightAscension("18:30:23.1");
    //we got here so no exception
    assert(true)
  }

  //bad hours range test
  test("string 25:18:23.1 throws an exception") {

    try {
      var ra = RightAscension("25:30:23.1");
    } catch {
      case ex: Exception => assert(ex.getMessage().equals("hours is beyond the normal rang of 0 - 24"))
    }

    //we got here this is bad
    assert(false)
  }

  test("string -1:18:23.1 throws an exception") {

    try {
      var ra = RightAscension("-1:30:23.1");
    } catch {
      case ex: Exception => assert(ex.getMessage().equals("hours is beyond the normal rang of 0 - 24"))
    }

    //we got here this is bad
    assert(false)
  }

  //bad minutes range test
  test("string 18:-1:23.1 throws an exception") {

    try {
      var ra = RightAscension("18:-1:23.1");
    } catch {
      case ex: Exception => assert(ex.getMessage().equals("minutes is beyond the normal rang of 0 - 59"))
    }

    //we got here this is bad
    assert(false)
  }

  test("string 18:61:23.1 throws an exception") {

    try {
      var ra = RightAscension("18:61:23.1");
    } catch {
      case ex: Exception => assert(ex.getMessage().equals("minutes is beyond the normal rang of 0 - 59"))
    }

    //we got here this is bad
    assert(false)
  }

  //bad seconds range test
  test("string 18:30:-1 throws an exception") {

    try {
      var ra = RightAscension("18:30:-1");
    } catch {
      case ex: Exception => assert(ex.getMessage().equals("seconds is beyond the normal rang of 0 - 59"))
    }

    //we got here this is bad
    assert(false)
  }

  test("string 18:30:61 throws an exception") {

    try {
      var ra = RightAscension("18:30:61");
    } catch {
      case ex: Exception => assert(ex.getMessage().equals("seconds is beyond the normal rang of 0 - 59"))
    }

    //we got here this is bad
    assert(false)
  }

  test("RA 18:30:23.1 should evaluate to 277.59625 degrees ") {

    var ra = RightAscension("18:30:23.10");
    assert(ra.asDegrees() == 277.59625)
  }

  test("RA 18:30:23.1 should evaluate to 4.844968554 radians ") {

    var ra = RightAscension("18:30:23.10");
    assert(ra.asRadians() == 4.844968554)
  }

}