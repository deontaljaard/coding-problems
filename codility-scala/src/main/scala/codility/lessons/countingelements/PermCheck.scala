package codility.lessons.countingelements

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 */
object PermCheck {

  def solution(a: Array[Int]): Int = {
    val set = a.toSet
    for (i <- Range(1, a.length + 1)) {
      if (!set.contains(i)) return 0
    }
    1
  }

  def main(args: Array[String]): Unit = {
    assert(solution(Array(4, 1, 3, 2)) == 1)
    assert(solution(Array(4, 1, 3)) == 0)
  }
}
