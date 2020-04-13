package dcp.problems._1_20

/**
 * This problem was asked by Google.
 *
 * An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields,
 * it holds a field named both, which is an XOR of the next node and the previous node.
 *
 * Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which
 * returns the node at index.
 */

object Problem6_XORDLL {

  class Node[A](val data: A, both: Node[A])

  def xor[A](n1: Node[A], n2: Node[A]): Node[A] = ???

  // behaves like append
  def add[A](data: A, head: Node[A]): Node[A] = ???

  def get[A](data: A, head: Node[A]): A = ???
}
