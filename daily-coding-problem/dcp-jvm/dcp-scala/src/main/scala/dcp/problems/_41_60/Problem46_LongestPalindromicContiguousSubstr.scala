package dcp.problems._41_60

/**
 * This problem was asked by Amazon.
 *
 * Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum
 * length, return any one.
 *
 * For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of
 * "bananas" is "anana".
 */

object Problem46_LongestPalindromicContiguousSubstr {

  val longest: (String, String) => String = (s1, s2) => if (s1.length > s2.length) s1 else s2

  def findLongestPalindrome(s: String): String = {
    if (s == s.reverse) s
    else {
      val s1 = findLongestPalindrome(s.substring(1))
      val s2 = findLongestPalindrome(s.substring(0, s.length - 1))
      longest(s1, s2)
    }
  }
}
