package dcp.problems._21_40

/**
 * This problem was asked by Facebook.
 *
 * Implement regular expression matching with the following special characters:
 *
 * . (period) which matches any single character
 * * (asterisk) which matches zero or more of the preceding element
 *
 * That is, implement a function that takes in a string and a valid regular expression and returns whether or not the
 * string matches the regular expression.
 *
 * For example, given the regular expression "ra." and the string "ray", your function should return true. The same
 * regular expression on the string "raymond" should return false.
 *
 * Given the regular expression ".*at" and the string "chat", your function should return true. The same regular
 * expression on the string "chats" should return false.
 */

object Problem25_Regex {

  def matches(regex: String, target: String): Boolean = {
    if (regex.isEmpty) target.isEmpty
    else {
      val firstMatch = !target.isEmpty && Set(target(0), '.').contains(regex(0))
      if (regex.length >= 2 && regex(1) == '*')
        matches(regex.substring(2), target) || (firstMatch && matches(regex, target.substring(1)))
      else
        firstMatch && matches(regex.substring(1), target.substring(1))
    }
  }
}
