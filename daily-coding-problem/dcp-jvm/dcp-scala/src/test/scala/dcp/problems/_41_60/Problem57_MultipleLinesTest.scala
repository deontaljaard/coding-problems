package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem57_MultipleLinesTest extends AnyFlatSpecLike with Matchers {

  "MultipleLines" should "break up the string into multiple lines such that each line has a length of k or less" in {
    val s = "the quick brown fox jumps over the lazy dog"
    Problem57_MultipleLines.break(s, 10) should be(List("the quick", "brown fox", "jumps over", "the lazy", "dog"))
    Problem57_MultipleLines.break("Delicious", 10) should be(Nil)
  }

}
