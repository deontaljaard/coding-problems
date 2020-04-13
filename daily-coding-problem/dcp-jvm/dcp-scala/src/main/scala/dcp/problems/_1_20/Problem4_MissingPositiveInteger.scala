package dcp.problems._1_20

/**
 * This problem was asked by Stripe.
 *
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array. The array can contain
 * duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */


object Problem4_MissingPositiveInteger {

  // O(n)
  def solution(arr: Array[Int]): Int = {
    val set = arr.toSet

    for (i <- Range(1, arr.length + 1)) {
      if (!set.contains(i)) return i
    }

    arr.length + 1
  }

}
