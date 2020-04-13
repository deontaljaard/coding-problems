package lessons.timecomplexity

import scala.math.{abs, min}

object TapeEquilibrium {
  val sliceArray: (Int, Array[Int]) => (Array[Int], Array[Int]) = (idx, arr) => (arr.slice(0, idx), arr.slice(idx, arr.length))

  def solution2(a: Array[Int]): Int = {
    var diffs = Set[Int]()
    for (i <- a.indices) {
      if (i > 0 || i < a.length) {
        val (arr1, arr2) = sliceArray(i, a)
        diffs += abs(arr1.sum - arr2.sum)
      }
    }
    diffs.min
  }

  def solution(a: Array[Int]): Int = {
    val totalSum = a.map(_.toLong).sum
    val result = a.foldLeft((-1, -1, 0L)) { case (acc, l) =>
      val (idx, currentMin, leftSum) = acc
      val index = idx + 1
      if (index + 1 == a.length) acc
      else {
        val left = leftSum + a(index)
        val right = totalSum - left
        val nextMin = abs(left - right)
        val newMin = if (currentMin == -1) nextMin else min(nextMin, currentMin)
        (index, newMin.toInt, left)
      }
    }
    result._2
  }

  def main(args: Array[String]): Unit = {
    // println(solution(Array(3, 1, 2, 4, 3)))
    assert(solution(Array(3, 1, 2, 4, 3)) == 1)
  }
}
