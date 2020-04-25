package dcp.problems._21_40

/**
 * This problem was asked by Google.
 *
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs
 * come first, the Gs come second, and the Bs come last. You can only swap elements of the array.
 *
 * Do this in linear time and in-place.
 *
 * For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 *
 * Reference: https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */

object Problem35_SegregateChars {

  def solution(input: Array[Char]): Array[Char] = {
    var low, mid = 0
    var high = input.length - 1
    var temp = 'R'
    while (mid <= high) {
      input(mid) match {
        case 'R' =>
          temp = input(low)
          input(low) = input(mid)
          input(mid) = temp
          low += 1
          mid += 1
        case 'G' => mid += 1
        case 'B' =>
          temp = input(mid)
          input(mid) = input(high)
          input(high) = temp
          high -= 1
      }
    }
    input
  }
}
