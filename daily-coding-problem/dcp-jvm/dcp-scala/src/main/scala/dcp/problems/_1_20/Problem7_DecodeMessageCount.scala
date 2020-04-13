package dcp.problems._1_20

/**
 * This problem was asked by Facebook.
 *
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */

object Problem7_DecodeMessageCount {

  def solution(msg: String): Int = {
    def count(chars: Array[Char]): Int = {
      if (chars.length <= 1) 1
      else if (inBounds(chars)) count(chars.drop(1)) + count(chars.drop(2))
      else count(chars.drop(1))
    }

    count(msg.toCharArray)
  }

  def inBounds(chars: Array[Char]): Boolean = {
    val num = chars.take(2).toList.mkString("").toInt
    num >= 1 && num <= 26
  }

}
