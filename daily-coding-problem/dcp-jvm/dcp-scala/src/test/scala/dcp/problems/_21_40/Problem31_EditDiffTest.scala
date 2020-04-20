package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem31_EditDiffTest extends AnyFlatSpecLike with Matchers {

  "EditDiff" should "determine the edit distance between two strings" in {
    Problem31_EditDiff.distance("kitten", "sitting") should be(3)
  }

}
