package dcp.problems._21_40

/**
 * This problem was asked by Microsoft.
 *
 * Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
 * If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction,
 * then return null.
 *
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should
 * return ['the', 'quick', 'brown', 'fox'].
 *
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either
 * ['bed', 'bath', 'and', 'beyond'] or ['bedbath', 'and', 'beyond'].
 */

object Problem22_OriginalSentence {

  def solution(dict: Seq[String], scrambled: String): Seq[String] = {
    @scala.annotation.tailrec
    def find(rem: String, dictRem: Seq[String], original: Seq[String] = Seq.empty[String]): Seq[String] = {
      if (rem.isEmpty) original
      else {
        dictRem match {
          case Nil => Seq.empty[String]
          case word :: tail =>
            if (rem.startsWith(word)) find(rem.substring(word.length), dict, original :+ word)
            else find(rem, tail, original)
        }
      }
    }

    find(scrambled, dict)
  }

}
