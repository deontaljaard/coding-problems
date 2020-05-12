package dcp.problems._1_20

/**
 * This problem was asked by Amazon.
 *
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct
 * characters.
 *
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */

object Problem13_LongestSubstring {

  def solution(k: Int, s: String): String = {
    @scala.annotation.tailrec
    def findLongest(rem: String, acc: String = "", longest: String = ""): String = {
      if (rem.isEmpty) longest
      else {
        val count = acc.toSet.size
        val c = rem.charAt(0)
        if (acc.contains(c)) findLongest(rem.substring(1), acc + c, longest)
        else if (!acc.contains(c) && count < k) findLongest(rem.substring(1), acc + c, longest)
        else findLongest(acc.substring(acc.length - 1) + rem, "", maxLen(acc, longest))
      }
    }

    if (k > 1) findLongest(s) else s(0).toString
  }

  def maxLen(s1: String, s2: String): String = if (s1.length > s2.length) s1 else s2
}
