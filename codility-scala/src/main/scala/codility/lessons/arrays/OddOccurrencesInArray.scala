package codility.lessons.arrays

/**
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */
object OddOccurrencesInArray {

  def solution(a: Array[Int]): Int = {
    val occurrences = scala.collection.mutable.Map[Int, Int]()
    // group
    for (i <- a.indices) {
      if (occurrences.contains(a(i))) occurrences(a(i)) += 1
      else occurrences(a(i)) = 1
    }

    // remove even
    for ((k, v) <- occurrences) {
      if (v % 2 == 0) occurrences.remove(k)
    }

    occurrences.head._1
  }

  def solution2(a: Array[Int]): Int =
    a.groupBy(identity)
      .view
      .mapValues(_.length)
      .toMap
      .filter(_._2 % 2 != 0)
      .minBy(_._2)._1

  def main(args: Array[String]): Unit = {
    assert(solution(Array(9, 3, 9, 3, 9, 7, 9)) == 7)
    assert(solution2(Array(9, 3, 9, 3, 9, 7, 9)) == 7)
  }
}
