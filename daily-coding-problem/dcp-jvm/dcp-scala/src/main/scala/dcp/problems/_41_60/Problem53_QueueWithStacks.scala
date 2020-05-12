package dcp.problems._41_60

import scala.collection.mutable

/**
 * This problem was asked by Apple.
 *
 * Implement a queue using two stacks. Recall that a queue is a FIFO (first-in, first-out) data structure with the
 * following methods:
 * enqueue, which inserts an element into the queue, and
 * dequeue, which removes it.
 */

object Problem53_QueueWithStacks {

  class Queue[A] {
    private val mainStack = mutable.Stack[A]()
    private val auxStack = mutable.Stack[A]()

    def enqueue(elem: A): Unit = mainStack.push(elem)

    def dequeue(): Option[A] = {
      if (mainStack.isEmpty) None
      else {
        while (mainStack.nonEmpty) auxStack.push(mainStack.pop())
        val elem = auxStack.pop()
        while (auxStack.nonEmpty) mainStack.push(auxStack.pop())
        Some(elem)
      }
    }
  }

}
