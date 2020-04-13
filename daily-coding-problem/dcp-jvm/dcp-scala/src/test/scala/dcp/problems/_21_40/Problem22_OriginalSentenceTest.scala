package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem22_OriginalSentenceTest extends AnyFlatSpecLike with Matchers {

  "OriginalSentence" should "should return the original sentence" in {
    Problem22_OriginalSentence.solution(List("quick", "brown", "the", "fox"), "thequickbrownfox") should be(List("the", "quick", "brown", "fox"))
    Problem22_OriginalSentence.solution(List("bed", "bath", "bedbath", "and", "beyond"), "bedbathandbeyond") should be(List("bed", "bath", "and", "beyond"))
  }

}
