package lessons.countingelements

import scala.collection.mutable

object MissingInteger {
  def solution(a: Array[Int]): Int = {
    if (a.isEmpty) return 1

    val set = mutable.Set[Int]()
    for (i <- a.indices) {
      set += a(i)
    }

    for (i <- Range(1, a.length + 1)) {
      if (!set.contains(i))
        return i
    }

    a.length + 1
  }


  def main(args: Array[String]): Unit = {
    assert(solution(Array(1, 3, 6, 4, 1, 2)) == 5)
    assert(solution(Array(1, 2, 3)) == 4)
    assert(solution(Array(-1, -3)) == 1)
    assert(solution(Array(2)) == 1)
  }
}
