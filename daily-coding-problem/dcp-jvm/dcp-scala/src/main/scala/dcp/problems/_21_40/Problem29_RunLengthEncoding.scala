package dcp.problems._21_40

/**
 * This problem was asked by Amazon.
 *
 * Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated
 * successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as
 * "4A3B2C1D2A".
 *
 * Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists
 * solely of alphabetic characters. You can assume the string to be decoded is valid.
 */

object Problem29_RunLengthEncoding {

  def encode(input: String): String = {
    @scala.annotation.tailrec
    def enc(chars: List[Char], currChar: Char, count: Int, acc: String = ""): String = chars match {
      case Nil => acc + s"$count$currChar"
      case c :: tail =>
        if (c == currChar) enc(tail, currChar, count + 1, acc)
        else enc(tail, c, 1, acc + s"$count$currChar")
    }

    if (input.isEmpty) "" else enc(input.tail.toList, input.head, 1)
  }

  def decode(output: String): String = {
    @scala.annotation.tailrec
    def dec(rem: String, acc: String = ""): String = {
      if (rem.isEmpty) acc
      else dec(rem.substring(2), acc + (rem.substring(1, 2) * rem.charAt(0).asDigit))
    }

    dec(output)
  }

  def decode2(output: String): String =
    output.toSeq.sliding(2, 2).map(s => s.subSequence(1, 2).toString * s.subSequence(0, 1).toString.toInt).mkString("")
}
