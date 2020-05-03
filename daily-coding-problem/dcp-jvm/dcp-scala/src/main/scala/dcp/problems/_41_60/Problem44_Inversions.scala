package dcp.problems._41_60

import scala.collection.mutable

/**
 * This problem was asked by Google.
 *
 * We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and
 * A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.
 *
 * Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
 *
 * You may assume each element in the array is distinct.
 *
 * For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions:
 * (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
 *
 * Reference: https://www.geeksforgeeks.org/counting-inversions/
 */

/**
 * function mergeSort(array) {
 * if (array.length === 1) {
 * // Return once we hit an array with a single item
 * return array
 * }
 *
 * // Get the middle item of the array rounded down by creating a variable
 * const middle = Math.floor(array.length / 2)
 * // Create a variable for the items on the left side
 * const left = array.slice(0, middle)
 * // Create a variable for the items on the right side
 * const right = array.slice(middle)
 *
 * return merge(
 * mergeSort(left),
 * mergeSort(right)
 * )
 * }
 *
 * // Compare the arrays item by item and return the concatenated result
 * function merge (left, right) {
 * let result = []
 * let indexLeft = 0
 * let indexRight = 0
 *
 * while (indexLeft < left.length && indexRight < right.length) {
 * if (left[indexLeft] < right[indexRight]) {
 *       result.push(left[indexLeft])
 * indexLeft++
 * } else {
 *       result.push(right[indexRight])
 * indexRight++
 * }
 * }
 *
 * return result.concat(left.slice(indexLeft)).concat(right.slice(indexRight))
 * }
 */

object Problem44_Inversions {

  type ArrayInversion = (Array[Int], Int)

  def inversions(A: Array[Int]): Int = {
    val (_, inversions) = mergeSort(A)
    inversions
  }

  def mergeSort(A: Array[Int]): ArrayInversion = {
    if (A.length <= 1) (A, 0)
    else {
      val middle = A.length / 2
      val left = A.slice(0, middle)
      val right = A.slice(middle, A.length)
      merge(mergeSort(left), mergeSort(right))
    }
  }

  def merge(leftArr: ArrayInversion, rightArr: ArrayInversion): ArrayInversion = {
    val merged = mutable.ArrayBuffer[Int]()
    var leftIdx, rightIdx = 0
    val (left, leftInversions) = leftArr
    val (right, rightInversions) = rightArr
    var inversions = leftInversions + rightInversions

    while (leftIdx < left.length && rightIdx < right.length) {
      if (left(leftIdx) < right(rightIdx)) {
        merged.append(left(leftIdx))
        leftIdx += 1
      } else {
        merged.append(right(rightIdx))
        rightIdx += 1
        inversions += left.slice(leftIdx, left.length).length
      }
    }

    merged.appendAll(left.slice(leftIdx, left.length)).appendAll(right.slice(rightIdx, right.length))

    (merged.toArray, inversions)
  }

  def inversions_2(A: Array[Int]): Int = (for (i <- A.indices; j <- A.indices if A(i) > A(j) && i < j) yield (i, j)).length
}
