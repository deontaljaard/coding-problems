package dcp.problems._21_40

/**
 * This problem was asked by Google.
 *
 * The edit distance between two strings refers to the minimum number of character insertions, deletions, and
 * substitutions required to change one string to the other. For example, the edit distance between
 * “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
 *
 * Given two strings, compute the edit distance between them.
 *
 * Reference: https://en.wikipedia.org/wiki/Levenshtein_distance
 */

object Problem31_EditDiff {

  def distance(s1: String, s2: String): Int = {
    if (s1 == s2) 0
    else if (s1.isEmpty) s2.length
    else if (s2.isEmpty) s1.length
    else if (s1.charAt(0) == s2.charAt(0)) distance(s1.substring(1), s2.substring(1))
    else {
      1 + math.min(
        distance(s1.substring(1), s2),
        math.min(
          distance(s1, s2.substring(1)),
          distance(s1.substring(1), s2.substring(1))
        )
      )
    }
  }
}
