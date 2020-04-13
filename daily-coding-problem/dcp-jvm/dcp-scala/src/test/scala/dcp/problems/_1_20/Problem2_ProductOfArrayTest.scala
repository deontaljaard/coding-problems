package dcp.problems._1_20

import org.scalatest.flatspec._
import org.scalatest.matchers.should.Matchers

class Problem2_ProductOfArrayTest extends AnyFlatSpecLike with Matchers {

  "ProductOfArray" should "calculate product of array (brute force) - O(n^2)" in {
    Problem2_ProductOfArray.solution(Array(1, 2, 3, 4, 5)) should be(Array(120, 60, 40, 30, 24))
    Problem2_ProductOfArray.solution(Array(3, 2, 1)) should be(Array(2, 3, 6))
  }

  it should "calculate product of array O(n)" in {
    Problem2_ProductOfArray.solution2(Array(1, 2, 3, 4, 5)) should be(Array(120, 60, 40, 30, 24))
    Problem2_ProductOfArray.solution2(Array(3, 2, 1)) should be(Array(2, 3, 6))
  }

}
