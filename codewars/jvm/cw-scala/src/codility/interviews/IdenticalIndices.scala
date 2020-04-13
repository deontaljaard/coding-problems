package codility.interviews


object IdenticalIndices {
  def solution(a: Array[Int]): Int = {
    var identicalIndices = 0
    for (i <- a.indices) {
      for (k <- Range(i + 1, a.length)) {
        if (identicalIndices > 1000000000) return identicalIndices
        if (a(i) == a(k)) identicalIndices += 1
      }
    }
    identicalIndices
  }

  def main(args: Array[String]): Unit = {
    assert(solution(Array(3, 5, 6, 3, 3, 5)) == 4)
    assert(solution(Array(3, 5, 6, 3)) == 1)
  }
}
