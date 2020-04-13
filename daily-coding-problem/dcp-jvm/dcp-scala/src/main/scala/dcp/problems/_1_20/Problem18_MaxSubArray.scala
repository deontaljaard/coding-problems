package dcp.problems._1_20

/**
 * This problem was asked by Google.
 *
 * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each
 * subarray of length k.
 *
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 *
 * 10 = max(10, 5, 2)
 * 7 = max(5, 2, 7)
 * 8 = max(2, 7, 8)
 * 8 = max(7, 8, 7)
 *
 * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the
 * results. You can simply print them out as you compute them.
 */

object Problem18_MaxSubArray {

  val printMax: Array[Int] => Unit = a => println(s"${a.max} = max(${a.mkString(", ")})")

  def solution1(A: Array[Int], k: Int): Unit = A.sliding(k, 1).foreach(printMax)

  def solution2(A: Array[Int], k: Int): Unit = {
    @scala.annotation.tailrec
    def compute(idx: Int, remK: Int, sub: Array[Int] = Array.empty[Int]): Unit = {
      if (remK >= 1) compute(idx + 1, remK - 1, sub :+ A(idx))
      else if (idx == A.length) printMax(sub)
      else {
        printMax(sub)
        compute(idx + 1, remK, sub.tail :+ A(idx))
      }
    }

    compute(0, 3)
  }

  def main(args: Array[String]): Unit = {
    solution1(Array(10, 5, 2, 7, 8, 7), 3)
    println()
    solution2(Array(10, 5, 2, 7, 8, 7), 3)
  }
}
