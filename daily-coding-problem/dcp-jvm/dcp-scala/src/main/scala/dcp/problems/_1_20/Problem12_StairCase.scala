package dcp.problems._1_20

/**
 * This problem was asked by Amazon.
 *
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function
 * that returns the number of unique ways you can climb the staircase. The order of the steps matters.
 *
 * For example, if N is 4, then there are 5 unique ways:
 *
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 *
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive
 * integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */

object Problem12_StairCase {

  // assuming either 1 or 2 steps
  def solution(n: Int): Int = {
    if (n == 0 || n == 1) 1
    else solution(n - 2) + solution(n - 1)
  }

  def solutionMemoized(n: Int): Int = {
    if (n == 0 || n == 1) return 1
    var prev, curr = 1
    for (i <- 2 to n) {
      val temp = curr
      curr = curr + prev
      prev = temp
    }
    curr
  }

  def solutionX(n: Int, X: Set[Int]): Int = {
    if (n == 0) return 1
    var total = 0
    for (i <- X)
      if (n - i >= 0) total += solutionX(n - i, X)
    total
  }
}


