package lessons.prefixsums

object CountDiv {

  // non-optimal solution O(n)
  def solution(a: Int, b: Int, k: Int): Int = {
    Range(a, b + 1).foldLeft(0) { case (acc, num) =>
      if (num % 2 == 0) acc + 1
      else acc
    }
  }

  def solution2(a: Int, b: Int, k: Int): Int = {
    val numB = Math.floor(b / k).toInt
    val numA = Math.floor(a / k).toInt
    val numDiv = numB - numA

    var plus = 0
    if (a % k == 0) plus = 1

    numDiv + plus
  }

  def solution3(a: Int, b: Int, k: Int): Int = {
    val count = (b / k - a / k)
    val plus = if (a % k == 0) 1 else 0
    count + plus
  }

  def main(args: Array[String]): Unit = {
    assert(solution3(6, 11, 2) == 3)
  }
}
