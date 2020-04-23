package dcp.problems._21_40

/**
 * This problem was asked by Quora.
 *
 * Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible
 * anywhere in the word. If there is more than one palindrome of minimum length that can be made, return the
 * lexicographically earliest one (the first one alphabetically).
 *
 * For example, given the string "race", you should return "ecarace", since we can add three letters to it
 * (which is the smallest amount to make a palindrome). There are seven other palindromes that can be made from "race"
 * by adding three letters, but "ecarace" comes first alphabetically.
 *
 * As another example, given the string "google", you should return "elgoogle".
 */

object Problem34_FindPalindrome {

  val shortest: (String, String) => String = (s1, s2) => if (s1.length < s2.length) s1 else s2
  val earliest: (String, String) => String = (s1, s2) => if (s1 < s2) s1 else s2

  def findPalindrome(s: String): String = {
    if (s == s.reverse) s
    else if (s(0) == s.reverse(0)) s(0) + findPalindrome(s.substring(1, s.length - 1)) + s.reverse(0)
    else {
      val p1 = s(0) + findPalindrome(s.substring(1)) + s(0)
      val p2 = s.reverse(0) + findPalindrome(s.substring(0, s.length - 1)) + s.reverse(0)

      if (p1.length != p2.length) shortest(p1, p2) else earliest(p1, p2)
    }
  }
}
