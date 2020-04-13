package dcp.problems._1_20

/**
 * This problem was asked by Uber.
 *
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of
 * all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */

object Problem2_ProductOfArray extends App {

  // brute force O(n^2)
  def solution(arr: Array[Int]): Array[Int] = {
    val result = new Array[Int](arr.length)
    for (i <- arr.indices) {
      var product = 1
      for (j <- arr.indices) {
        if (i != j) {
          product *= arr(j)
        }
      }
      result(i) = product
    }
    result
  }

  // O(n)
  def solution2(arr: Array[Int]): Array[Int] = {
    val cumulativeProduct = arr.foldLeft((List.empty[Int], 1)) { case ((xs, product), elem) =>
      val prod = product * elem
      (xs :+ prod, prod)
    }._1

    val cumulativeProductReverse = arr.reverse.foldLeft((List.empty[Int], 1)) { case ((xs, product), elem) =>
      val prod = product * elem
      (xs :+ prod, prod)
    }._1.reverse

    val result = new Array[Int](arr.length)
    for (i <- arr.indices) {
      if (i == 0) result(i) = cumulativeProductReverse(i + 1)
      else if (i == arr.length - 1) result(i) = cumulativeProduct(i - 1)
      else result(i) = cumulativeProduct(i - 1) * cumulativeProductReverse(i + 1)
    }
    result
  }

}
