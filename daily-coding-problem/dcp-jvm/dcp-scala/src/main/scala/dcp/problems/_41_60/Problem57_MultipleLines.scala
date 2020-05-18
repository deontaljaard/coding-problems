package dcp.problems._41_60

/**
 * This problem was asked by Amazon.
 *
 * Given a string s and an integer k, break up the string into multiple lines such that each line has a length of k or
 * less. You must break it up so that words don't break across lines. Each line has to have the maximum possible amount
 * of words. If there's no way to break the text up, then return null.
 *
 * You can assume that there are no spaces at the ends of the string and that there is exactly one space between each
 * word.
 *
 * For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return:
 * ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.
 */

object Problem57_MultipleLines {

  def break(s: String, k: Int): List[String] = {
    @scala.annotation.tailrec
    def process(words: List[String], line: String = "", acc: List[String] = List.empty[String]): List[String] = words match {
      case Nil => if (line.isEmpty) acc else acc :+ line
      case x :: xs =>
        val tempAcc = if (line.isEmpty) x else line + " " + x
        if (tempAcc.length > k) process(xs, x, acc :+ line)
        else process(xs, tempAcc, acc)
    }

    val words = s.split(" ")
    if (words.length > 1) process(words.toList) else Nil
  }

}
