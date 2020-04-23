package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem34_FindPalindromeTest extends AnyFlatSpecLike with Matchers {

  "FindPalindrome" should "find palindrome in string" in {
    Problem34_FindPalindrome.findPalindrome("race") should be("ecarace")
    Problem34_FindPalindrome.findPalindrome("google") should be("elgoogle")
  }

}
