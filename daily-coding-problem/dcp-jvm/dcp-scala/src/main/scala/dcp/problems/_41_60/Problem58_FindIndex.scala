package dcp.problems._41_60

/**
 * This problem was asked by Amazon.
 *
 * An sorted array of integers was rotated an unknown number of times.
 *
 * Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't
 * exist in the array, return null.
 *
 * For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).
 *
 * You can assume all the integers in the array are unique.
 */

object Problem58_FindIndex {

  def findIndex(arr: Array[Int], elem: Int): Int = {
    @scala.annotation.tailrec
    def findBetween(start: Int, end: Int): Int = {
      if(start == end) -1
      else {
        val mid = (start + (end - start)) / 2
        if (arr(mid) == elem) mid
        else if (arr(mid) > elem) {
          if (arr(start) >= elem) findBetween(start, mid) else findBetween(mid, end)
        } else {
          if (arr(start) <= elem) findBetween(start, mid) else findBetween(mid, end)
        }
      }
    }
    findBetween(0, arr.length)
  }

}
