package dcp.problems._1_20

/**
 * This problem was asked by Google.
 *
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */

object Problem1_PairsWithSum {

  // brute force O(n^2)
  def solution(arr: Array[Int], sum: Int): Boolean = {
    for (i <- arr.indices) {
      val acc = sum - arr(i)
      for (j <- (i + 1) until arr.length) {
        if (acc - arr(j) == 0) return true
      }
    }
    false
  }

  // using complements O(n) - single pass
  def solution2(arr: Array[Int], sum: Int): Boolean = {
    var complements = Set.empty[Int]
    for (i <- arr.indices) {
      if (complements.contains(arr(i))) return true
      complements += sum - arr(i)
    }
    false
  }


}
