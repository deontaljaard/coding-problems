package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem49_MaxSumTest extends AnyFlatSpecLike with Matchers {
  "MaxSum" should "find the maximum sum of any contiguous subarray of the array" in {
    Problem49_MaxSum.findMaxSum(Array(34, -50, 42, 14, -5, 86)) should be(137)
    Problem49_MaxSum.findMaxSum(Array(44, -5, 42, 14, -150, 86)) should be(95)
    Problem49_MaxSum.findMaxSum(Array(-5, -1, -8, -9)) should be(0)

    Problem49_MaxSum.findMaxSum2(Array(34, -50, 42, 14, -5, 86)) should be(137)
    Problem49_MaxSum.findMaxSum2(Array(44, -5, 42, 14, -150, 86)) should be(95)
    Problem49_MaxSum.findMaxSum2(Array(-5, -1, -8, -9)) should be(0)
  }
}
