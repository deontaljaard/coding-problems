package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem28_JustifyTextTest extends AnyFlatSpecLike with Matchers {

  "JustifyText" should "should evenly distribute spaces between words to justify text" in {
    val sentence = List("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog")
    val expected = List("the  quick brown", // 1 extra space on the left
      "fox  jumps  over", // 2 extra spaces distributed evenly
      "the   lazy   dog") // 4 extra spaces distributed evenly
    Problem28_JustifyText.solution(sentence, 16) should be(expected)
  }

}
