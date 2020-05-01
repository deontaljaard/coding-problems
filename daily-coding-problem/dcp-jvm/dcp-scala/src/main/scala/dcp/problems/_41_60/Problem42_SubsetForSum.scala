package dcp.problems._41_60

/**
 * This problem was asked by Google.
 *
 * Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k.
 * If such a subset cannot be made, then return null.
 *
 * Integers can appear more than once in the list. You may assume all numbers in the list are positive.
 *
 * For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
 */

object Problem42_SubsetForSum {

  def subsetForSum(in: List[Int], k: Int): List[Int] = in match {
    case Nil => Nil
    case x :: _ if x == k => List(x)
    case x :: xs =>
      val elems = subsetForSum(xs, k - x)
      if (elems.nonEmpty) List(x) ++ elems
      else subsetForSum(xs, k)
  }
}
