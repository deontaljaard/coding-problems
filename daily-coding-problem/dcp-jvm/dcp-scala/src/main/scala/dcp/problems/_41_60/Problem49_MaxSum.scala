package dcp.problems._41_60

/**
 * This problem was asked by Amazon.
 *
 * Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
 *
 * For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements
 * 42, 14, -5, and 86.
 *
 * Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.
 *
 * Do this in O(N) time.
 */

object Problem49_MaxSum {

  def findMaxSum(arr: Array[Int]): Int = {
    if (arr.max < 0) 0
    else {
      val (_, overallMax) = arr.tail.foldLeft((arr(0), arr(0))) { case ((currentMax, overallMax), elem) =>
        val newCurrentMax = math.max(elem, currentMax + elem)
        (newCurrentMax, math.max(newCurrentMax, overallMax))
      }
      overallMax
    }
  }

  def findMaxSum2(arr: Array[Int]): Int = {
    (1 to arr.length).foldLeft(0) { case (max, size) =>
      val subMax = arr.sliding(size, 1).map(_.sum).max
      if (subMax > max) subMax else max
    }
  }
}
