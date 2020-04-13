package dcp.problems._1_20

/**
 * This problem was asked by Airbnb.
 *
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 * Numbers can be 0 or negative.
 *
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10,
 * since we pick 5 and 5.
 */

object Problem9_LargestSum {

  type PreviousLargest = (Int, Int)

  def solution(a: Array[Int]): Int = {
    val (_, largest): PreviousLargest = a.foldLeft((0, 0)) { case ((previous, largest), elem) =>
      (largest, math.max(largest, previous + elem))
    }
    largest
  }

}
