package dcp.problems._21_40

/**
 * This problem was asked by Facebook.
 *
 * You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is
 * unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.
 *
 * Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
 *
 * For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
 *
 * Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth
 * index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
 */

object Problem30_WaterTrap {

  def solution(walls: Array[Int]): Int = {
    if (walls.length < 3) 0
    else {
      var totalVolume, left, leftMax, rightMax = 0
      var right = walls.length - 1
      while (left <= right) {
        if (walls(left) < walls(right)) {
          if (walls(left) > leftMax) leftMax = walls(left)
          else totalVolume += leftMax - walls(left)
          left += 1
        } else {
          if (walls(right) > rightMax) rightMax = walls(right)
          else totalVolume += rightMax - walls(right)
          right -= 1
        }
      }
      totalVolume
    }
  }
}
