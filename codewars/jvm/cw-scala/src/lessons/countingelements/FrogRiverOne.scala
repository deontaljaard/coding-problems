package lessons.countingelements

import scala.collection.mutable

object FrogRiverOne {

  def solution(x: Int, a: Array[Int]): Int = {
    val set = mutable.Set() ++ Range(1, x + 1).toSet
    for (i <- a.indices) {
      if (set.contains(a(i))) set.remove(a(i))
      if (set.isEmpty) return i
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    assert(solution(5, Array(1, 3, 1, 4, 2, 3, 5, 4)) == 6)
    assert(solution(2, Array(1, 2, 3)) == 1)
    assert(solution(3, Array(1, 3, 2)) == 2)
    assert(solution(5, Array(3)) == -1)
  }

}
