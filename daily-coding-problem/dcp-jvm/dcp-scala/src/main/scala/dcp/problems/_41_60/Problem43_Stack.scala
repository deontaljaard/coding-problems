package dcp.problems._41_60

import scala.collection.mutable

/**
 * This problem was asked by Amazon.
 *
 * Implement a stack that has the following methods:
 *
 * push(val), which pushes an element onto the stack
 * pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it
 * should throw an error or return null.
 * max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it
 * should throw an error or return null.
 *
 * Each method should run in constant time.
 */

object Problem43_Stack {

  class Stack() {
    private var elements = mutable.ArrayBuffer[Int]()
    private var maxTracker = mutable.ArrayBuffer[Int]()

    def push(element: Int): Unit = {
      elements.prepend(element)
      if (element > maxTracker.headOption.getOrElse(0)) maxTracker.prepend(element)
      else maxTracker.prepend(maxTracker.head)
    }

    def pop(): Int = {
      if (elements.isEmpty) throw new Exception("Stack is empty!")
      val element = elements.head
      elements.remove(0)
      maxTracker.remove(0)
      element
    }

    def max: Int = maxTracker.headOption.getOrElse(0)

    protected[_41_60] def getMemory: Array[Int] = elements.toArray
  }

}
