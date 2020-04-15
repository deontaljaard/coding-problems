package dcp.problems._21_40

/**
 * This problem was asked by Google.
 *
 * Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller
 * than the length of the list.
 *
 * The list is very long, so making more than one pass is prohibitively expensive.
 *
 * Do this in constant space and in one pass.
 */

object Problem26_SSLFindKthFromEnd {

  case class Node[A](data: A, next: Node[A] = null)

  def findKthFromEnd[A](node: Node[A], k: Int): Node[A] = {
    @scala.annotation.tailrec
    def findKth(current: Node[A], kth: Node[A], count: Int): Node[A] = {
      if (current == null) kth
      else if (count >= 0) findKth(current.next, kth, count - 1)
      else findKth(current.next, kth.next, count)
    }

    findKth(node, node, k)
  }

  def findKthFromEnd2[A](node: Node[A], k: Int): Node[A] = {
    if (node == null) null
    else {
      var current = node
      var kth = node
      var count = k
      while (current.next != null) {
        current = current.next
        if (count > 0) {
          count -= 1
        } else {
          kth = kth.next
        }
      }
      kth
    }
  }

}
