package dcp.problems._21_40

/**
 * This problem was asked by Google.
 *
 * Given an array of integers where every integer occurs three times except for one integer, which only occurs once,
 * find and return the non-duplicated integer.
 *
 * For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
 *
 * Do this in O(N) time and O(1) space.
 *
 * Reference: https://www.geeksforgeeks.org/find-the-element-that-appears-once/
 */

object Problem40_NonDuplicate {

  def solution(in: Array[Int]): Int = {
    var ones, twos = 0
    var commonBitMask = 0
    for (i <- in) {
      twos |= (ones & i)
      ones ^= i
      commonBitMask = ~(ones & twos)
      ones &= commonBitMask
      twos &= commonBitMask
    }
    ones
  }

  def solution2(in: Array[Int]): Int = {
    val group = in.foldLeft(Map.empty[Int, Int]) { case (acc, elem) =>
      val i: Int = acc.getOrElse(elem, 1) + 1
      acc + (elem -> i)
    }
    group.toSeq.minBy(_._2)._1
  }
}
