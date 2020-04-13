package codility.interviews


object BugfixingLeaderSorted {
  def solution(a: Array[Int]): Int = {
    val counts = a.groupBy(identity)
    val leader = counts.keysIterator.reduceLeft((a, b) => if (counts(a).length > counts(b).length) a else b)
    val i = if (counts(leader).length > (a.length / 2)) leader else -1
    i
  }

  def main(args: Array[String]): Unit = {
    assert(solution(Array(2, 2, 2, 2, 2, 3, 4, 4, 4, 6)) == -1)
    assert(solution(Array(1, 1, 1, 1, 50)) == 1)
  }
}
