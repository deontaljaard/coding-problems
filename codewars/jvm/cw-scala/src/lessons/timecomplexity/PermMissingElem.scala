package lessons.timecomplexity


object PermMissingElem {

  // prone to integer overflow, use long instead
  def solution(a: Array[Int]): Int = {
    val targetSum = (a.length.toLong + 1) * (a.length.toLong + 2) / 2
    val actualSum = a.sum.toLong
    (targetSum - actualSum).toInt
  }

  def main(args: Array[String]): Unit = {
    assert(solution(Array(2, 3, 1, 5)) == 4)
    assert(solution(Array(2, 3, 1, 5, 6)) == 4)
    assert(solution(Array(2, 3, 1, 4, 6)) == 5)
    assert(solution(Array(2, 3, 1, 4, 6, 7, 8, 9)) == 5)
  }
}
