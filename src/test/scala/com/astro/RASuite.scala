package com.astro

import org.scalatest.FunSuite

class RASuite extends FunSuite {
  test("can interpret ra string 18:30:23.1") {
    var ra = RightAccention("18:30:23.1");
    //we got here so no exception
    assert(true)
  }

  test("string 77:18:23.1 throws an exception") {

    try {
      var ra = RightAccention("18:30:23.1");
    } catch {
      case ex: Exception => assert(true)
    }

    //we got here this is bad
    assert(false)
  }
}