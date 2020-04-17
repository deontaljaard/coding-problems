package dcp.problems._21_40

/**
 * This problem was asked by Palantir.
 *
 * Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings
 * which represents each line, fully justified.
 *
 * More specifically, you should have as many words as possible in each line. There should be at least one space between
 * each word. Pad extra spaces when necessary so that each line has exactly length k. Spaces should be distributed as
 * equally as possible, with the extra spaces, if any, distributed starting from the left.
 *
 * If you can only fit one word on a line, then you should pad the right-hand side with spaces.
 *
 * Each word is guaranteed not to be longer than k.
 *
 * For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and
 * k = 16, you should return the following:
 *
 * ["the  quick brown", # 1 extra space on the left
 * "fox  jumps  over", # 2 extra spaces distributed evenly
 * "the   lazy   dog"] # 4 extra spaces distributed evenly
 */

object Problem28_JustifyText {


  def solution(input: List[String], k: Int): List[String] = {
    @scala.annotation.tailrec
    def groupAndJustify(remWords: List[String],
                        words: List[String] = List.empty[String],
                        result: List[String] = List.empty[String]): List[String] = remWords match {
      case Nil => result :+ justify(words, k)
      case word :: tail =>
        if (words.mkString(" ").length + word.length + 1 > k) groupAndJustify(remWords, List.empty[String], result :+ justify(words, k))
        else groupAndJustify(tail, words :+ word, result)
    }

    groupAndJustify(input)
  }

  def justify(words: List[String], k: Int): String = {
    val lineLength = words.mkString(" ").length
    val spacesToAdd = k - lineLength
    val guaranteedSpaces = 1 + (spacesToAdd / (words.size - 1))
    val bonusSpaceRecipients = spacesToAdd % (words.size - 1)
    val res = words.slice(0, words.size - 1).zipWithIndex.foldLeft("") { case (acc, (word, idx)) =>
      if (idx < bonusSpaceRecipients) acc + word + " " * (guaranteedSpaces + 1)
      else acc + word + " " * guaranteedSpaces
    }
    res + words.reverse.head
  }
}
