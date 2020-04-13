package dcp.problems._1_20

import org.scalatest.flatspec._
import org.scalatest.matchers.should.Matchers

class Problem1_PairsWithSumTest extends AnyFlatSpecLike with Matchers {

  "PairsWithSum" should "determine if sum exists in array (brute force) - O(n^2)" in {
    Problem1_PairsWithSum.solution(Array(1, 2, 4, 9), 8) should be(false)
    Problem1_PairsWithSum.solution(Array(1, 2, 4, 4), 8) should be(true)
    Problem1_PairsWithSum.solution(Array(1, 2, 4, 6, 3), 5) should be(true)
    Problem1_PairsWithSum.solution(Array(10, 15, 3, 7), 17) should be(true)
  }

  it should "determine if sum exists in array in single pass - O(n)" in {
    // O(n)
    Problem1_PairsWithSum.solution2(Array(1, 2, 4, 9), 8) should be(false)
    Problem1_PairsWithSum.solution2(Array(1, 2, 4, 4), 8) should be(true)
    Problem1_PairsWithSum.solution2(Array(1, 2, 4, 6, 3), 5) should be(true)
    Problem1_PairsWithSum.solution2(Array(10, 15, 3, 7), 17) should be(true)
  }

}
