package dcp.problems._1_20

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem4_MissingPositiveIntegerTest extends AnyFlatSpecLike with Matchers {

  "MissingPositiveInteger" should "find positive integer" in {
    Problem4_MissingPositiveInteger.solution(Array(3, 4, -1, 1)) should be(2)
    Problem4_MissingPositiveInteger.solution(Array(1, 2, 0)) should be(3)
    Problem4_MissingPositiveInteger.solution(Array(1, 3, 6, 4, 1, 2)) should be(5)
    Problem4_MissingPositiveInteger.solution(Array(1, 2, 3)) should be(4)
    Problem4_MissingPositiveInteger.solution(Array(-1, -3)) should be(1)
    Problem4_MissingPositiveInteger.solution(Array(2)) should be(1)
  }
}
