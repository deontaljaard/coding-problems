package dcp.problems._1_20

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem9_LargestSumTest extends AnyFlatSpecLike with Matchers {

  "LargestSum" should "should find largest sum in array" in {
    Problem9_LargestSum.solution(Array(2, 4, 6, 2, 5)) should be(13)
    Problem9_LargestSum.solution(Array(5, 1, 1, 5)) should be(10)
  }
}
