package dcp.problems._1_20

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem13_LongestSubstringTest extends AnyFlatSpecLike with Matchers {

  "LongestSubstring" should "return the longest substring" in {
    Problem13_LongestSubstring.solution(2, "abcba") should be(3) // "bcb"
    Problem13_LongestSubstring.solution(2, "aaabbbbcccdd") should be(7) // "aaabbbb"
  }

}
