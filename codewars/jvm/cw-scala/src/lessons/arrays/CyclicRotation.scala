package lessons.arrays

object CyclicRotation {

  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.length == k) a
    else if (a.toSet.size == 1) a
    else {
      val size = a.length
      val result = Array.fill(a.length)(0)
      for (i <- a.indices) {
        result((i + k) % size) = a(i)
      }
      result
    }
  }

  def main(args: Array[String]): Unit = {
    assert(java.util.Arrays.equals(solution(Array(3, 8, 9, 7, 6), 3), Array(9, 7, 6, 3, 8)))
    assert(java.util.Arrays.equals(solution(Array(0, 0, 0), 1), Array(0, 0, 0)))
    assert(java.util.Arrays.equals(solution(Array(1, 2, 3, 4), 4), Array(1, 2, 3, 4)))
  }
}
