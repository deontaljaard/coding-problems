package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem46_LongestPalindromicContiguousSubstrTest extends AnyFlatSpecLike with Matchers {

  "LongestPalindromicContiguousSubstr" should "find the longest palindromic contiguous substring" in {
    Problem46_LongestPalindromicContiguousSubstr.findLongestPalindrome("aabcdcb") should be("bcdcb")
    Problem46_LongestPalindromicContiguousSubstr.findLongestPalindrome("bananas") should be("anana")
  }

}
