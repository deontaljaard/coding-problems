package dcp.problems._1_20

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem7_DecodeMessageCountTest extends AnyFlatSpecLike with Matchers {

  "DecodeMessageCount" should "decode '111'" in {
    Problem7_DecodeMessageCount.solution("111") should be(3) // aaa, ak, ka
  }

  it should "decode '113'" in {
    Problem7_DecodeMessageCount.solution("113") should be(3) // aaa, am, ma
  }

  it should "decode '1'" in {
    Problem7_DecodeMessageCount.solution("1") should be(1) // a
  }

}
