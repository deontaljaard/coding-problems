package dcp.problems._1_20

import scala.collection.mutable

/**
 * This problem was asked by Google.
 *
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 *
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 *
 * In this example, assume nodes with the same value are the exact same node objects.
 *
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */

object Problem20_SSLIntersection {

  case class Node(value: Int, next: Node = null)

  def intersection(n1: Node, n2: Node): Node = {
    val seen = mutable.Set[Int]()

    var current = n1
    while (current != null) {
      seen.add(current.value)
      current = current.next
    }

    current = n2
    while (current != null) {
      if (seen.contains(current.value)) return current
      current = current.next
    }

    null
  }
}
