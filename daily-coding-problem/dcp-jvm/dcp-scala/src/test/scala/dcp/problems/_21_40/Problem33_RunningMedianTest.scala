package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem33_RunningMedianTest extends AnyFlatSpecLike with Matchers {

  "RunningMedian" should "compute the running median of a sequence of numbers" in {
    Problem33_RunningMedian.solution(Array()) should be(Array())
    Problem33_RunningMedian.solution(Array(2, 5)) should be(Array(2, 3.5))
    Problem33_RunningMedian.solution(Array(2, 2, 2)) should be(Array(2, 2, 2))
    Problem33_RunningMedian.solution(Array(2, 1, 5, 7, 2, 0, 5)) should be(Array(2, 1.5, 2, 3.5, 2, 2, 2))
  }

}
