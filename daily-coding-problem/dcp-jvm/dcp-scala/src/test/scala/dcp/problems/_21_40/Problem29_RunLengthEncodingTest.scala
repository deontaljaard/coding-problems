package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem29_RunLengthEncodingTest extends AnyFlatSpecLike with Matchers {

  "RunLengthEncoding" should "should encode a string" in {
    Problem29_RunLengthEncoding.encode("AAAABBBCCDAA") should be("4A3B2C1D2A")
  }

  "RunLengthEncoding" should "should decode an encoded string" in {
    Problem29_RunLengthEncoding.decode("4A3B2C1D2A") should be("AAAABBBCCDAA")
    Problem29_RunLengthEncoding.decode2("4A3B2C1D2A") should be("AAAABBBCCDAA")
  }

}
