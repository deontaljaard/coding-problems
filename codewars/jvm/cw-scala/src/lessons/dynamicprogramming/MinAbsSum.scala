package lessons.dynamicprogramming

object MinAbsSum {

  val S: Array[Int] = Array(-1, 1)

  def solution(A: Array[Int]): Int = {
    var result = 0
    for (i <- A.indices) {
      result += A(i) * S(i % 2)
    }
    math.abs(result)
  }

  def main(args: Array[String]): Unit = {
//    assert(solution(Array(1, 5, 2, -2)) == 0)
//    assert(solution(Array(7)) == 7)
    assert(solution(Array(3, 3, 3, 4, 5)) == 0)
  }
}
