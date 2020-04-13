package lessons.countingelements

object MaxCounters {

  // too slow for large inputs - 66% performance,
  def solution2(n: Int, a: Array[Int]): Array[Int] = {
    a.foldLeft(new Array[Int](n)) { case (acc, elem) =>
      if (elem > n) {
        val max = acc.max
        acc.map { case a if a < max => max; case a => a }
      }
      else acc.updated(elem - 1, acc(elem - 1) + 1)
    }
  }

  def solution(n: Int, a: Array[Int]): Array[Int] = {
    val counters = new Array[Int](n)

    var max, maxCounter = 0
    for (count <- a) {
      if (count > n) maxCounter = max
      else {
        if (counters(count - 1) < maxCounter)
          counters(count - 1) = maxCounter
        counters(count - 1) += 1
        max = max.max(counters(count - 1))
      }
    }

    for (i <- counters.indices) {
      if (counters(i) < maxCounter) counters(i) = maxCounter
    }

    counters
  }


  def main(args: Array[String]): Unit = {
    println(solution(5, Array(3, 4, 4, 6, 1, 4, 4)).toList)
    assert(solution(5, Array(3, 4, 4, 6, 1, 4, 4)) sameElements Array(3, 2, 2, 4, 2))
  }
}
