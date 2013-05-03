package com.astro

import org.scalatest.FunSuite
/**
 * Test the right Declenation model
 */
class DecSuite extends FunSuite {
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

  test("Dec 18:30:23.1 should evaluate to 25.59625 degrees ") {

    var dec = Declination("18:30:23.10");
    assert(dec.asDegrees() == 25.59625)
  }

  test("Dec 18:30:23.1 should evaluate to 0.446738839 radians ") {
    var dec = Declination("18:30:23.10");
    println("Dec 18.30.23.10 asRadians = " + dec.asRadians())
    assert(dec.asRadians() == 0.446738839)
  }

}