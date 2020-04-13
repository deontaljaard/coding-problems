package dcp.problems._1_20

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem12_StairCaseTest extends AnyFlatSpecLike with Matchers {

  "StairCase" should "return unique ways of climbing stair case" in {
    Problem12_StairCase.solution(3) should be(3)
    Problem12_StairCase.solution(4) should be(5)
    Problem12_StairCase.solution(5) should be(8)

    Problem12_StairCase.solutionMemoized(3) should be(3)
    Problem12_StairCase.solutionMemoized(4) should be(5)
    Problem12_StairCase.solutionMemoized(5) should be(8)
  }

  "StairCase" should "return unique ways of climbing stair case with X = {1, 3, 5}" in {
    val X = Set(1, 3, 5)
    Problem12_StairCase.solutionX(3, X) should be(2)
    Problem12_StairCase.solutionX(4, X) should be(3)
    Problem12_StairCase.solutionX(5, X) should be(5)
  }
}
