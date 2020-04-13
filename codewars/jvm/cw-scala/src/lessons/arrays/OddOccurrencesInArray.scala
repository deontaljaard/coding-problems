package lessons.arrays

object OddOccurrencesInArray {

  def solution(a: Array[Int]): Int = {
    val occurrences = scala.collection.mutable.Map[Int, Int]()
    // group
    for (i <- a.indices) {
      if (occurrences.get(a(i)).nonEmpty) occurrences(a(i)) += 1
      else occurrences(a(i)) = 1
    }

    // remove even
    for ((k, v) <- occurrences) {
      if (v % 2 == 0) occurrences.remove(k)
    }

    occurrences.head._1
  }

  def solution2(a: Array[Int]): Int = a.groupBy(identity).view.mapValues(_.length).toMap.filter(_._2 % 2 != 0).minBy(_._2)._1

  def main(args: Array[String]): Unit = {
    assert(solution(Array(9, 3, 9, 3, 9, 7, 9)) == 7)
  }
}
