package codility.lessons.prefixsums

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 *
 * Reference: https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/
 */

object MinAvgTwoSlice {

  def solution(a: Array[Int]): Int = {
    var minAvg = (a(0) + a(1)) / 2.0
    var minAvgPos = 0

    for (i <- 0 to a.length - 3) {
      val twoAvg = (a(i) + a(i + 1)) / 2.0
      if (twoAvg < minAvg) {
        minAvg = twoAvg
        minAvgPos = i
      }
      val threeAvg = (a(i) + a(i + 1) + a(i + 2)) / 3.0
      if (threeAvg < minAvg) {
        minAvg = threeAvg
        minAvgPos = i
      }
    }

    minAvgPos
  }

  def solution2(a: Array[Int]): Int = {
    var minAvgPos = 0
    val N = a.length + 1
    val prefix = new Array[Int](N)
    for (i <- 1 until N) {
      prefix(i) = prefix(i - 1) + a(i - 1)
    }
    var minAvg = Double.MaxValue
    for (i <- 1 until N) {
      for (j <- 1 until N) {
        val tmp = (prefix(j) - prefix(i - 1)).toDouble / (j - i + 1).toDouble
        if (tmp < minAvg) {
          minAvg = tmp
          minAvgPos = i - 1
        }
      }
    }
    minAvgPos
  }

  def main(args: Array[String]): Unit = {
    val i = solution(Array(4, 2, 2, 5, 1, 5, 8))
    assert(i == 1)
  }
}
