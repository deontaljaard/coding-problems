package dcp.problems._21_40

/**
 * This problem was asked by Google.
 *
 * The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.
 *
 * For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
 *
 * You may also use a list or array to represent a set.
 */

object Problem37_PowerSet {

  def solution(in: Set[Int]): Set[Set[Int]] = {
    @scala.annotation.tailrec
    def power(rem: List[Int], acc: Set[Set[Int]] = Set(Set.empty)): Set[Set[Int]] = rem match {
      case Nil => acc
      case h :: t => power(t, acc + acc.map(_ + h))
    }

    power(in.toList)
  }
}
