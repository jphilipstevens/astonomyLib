package lib.astro

import org.scalatest.FeatureSpec

class DeclinationSpec extends FeatureSpec {

  feature("I should be able to parse strings that represent declination") {
    scenario("Declination string 1:2:3.4 should be parsed properly") {
      val declination = Declination("1:2:3.4").getOrElse(fail("Parsing Declination Failed"))
      assert(declination.degrees == 1)
      assert(declination.minutes == 2)
      assert(declination.seconds.equals(BigDecimal(3.4)))
    }

    scenario("Negative degrees like -1:2:3.4 should also be parsed") {
      val declination = Declination("-1:2:3.4").getOrElse(fail("Parsing Declination Failed"))
      assert(declination.degrees == -1)
      assert(declination.minutes == 2)
      assert(declination.seconds.equals(BigDecimal(3.4)))
    }

    scenario("Non numeric values for degrees like a:2:3.4 should not be parsed") {
      assert(Declination("a:2:3.4").isFailure)
    }

    scenario("Non-integer values for degrees like 22.5:2:3.4 should not be parsed") {
      assert(Declination("22.5:2:3.4").isFailure)
    }

    scenario("Non-Numeric values for minutes like 1:a:3.4 should be parsed") {
      assert(Declination("1:a:3.4").isFailure)
    }

    scenario("non-integer values for minutes like 1:30.5:3.4 should not be parsed") {
      assert(Declination("1:30.5:3.4").isFailure)
    }

    scenario("Minutes can not accept less than 0 minutes") {
      assert(Declination("1:-1:3.4").isFailure)
    }

    scenario("Minutes can not accept values over 60 minutes") {
      assert(Declination("1:61:3.4").isFailure)
    }

    scenario("Non-numeric values for seconds will not be accepted") {
      assert(Declination("1:2:aa").isFailure)
    }

    scenario("Integer values for seconds is allowed") {
      val declination = Declination("1:2:3").getOrElse(fail("Declination value 1:2:3 could not be parsed"))
      assert(declination.seconds.equals(BigDecimal(3)))
    }
  }

}
