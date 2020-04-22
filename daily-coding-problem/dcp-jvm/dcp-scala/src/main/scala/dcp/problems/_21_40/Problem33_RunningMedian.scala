package dcp.problems._21_40

import scala.collection.mutable

/**
 * This problem was asked by Microsoft.
 *
 * Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the
 * list so far on each new element.
 *
 * Recall that the median of an even-numbered list is the average of the two middle numbers.
 *
 * For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
 *
 * 2
 * 1.5
 * 2
 * 3.5
 * 2
 * 2
 * 2
 */

object Problem33_RunningMedian extends App {

  def solution(input: Array[Int]): Array[Double] = {
    val minHeap = mutable.PriorityQueue.empty(Ordering[Int].reverse)
    val maxHeap = mutable.PriorityQueue.empty(Ordering[Int])
    val medians = new Array[Double](input.length)

    for (i <- input.indices) {
      minHeap.enqueue(input(i))
      if (minHeap.size > maxHeap.size + 1) maxHeap.enqueue(minHeap.dequeue())

      if (minHeap.size == maxHeap.size) medians(i) = (minHeap.head + maxHeap.head) / 2.0
      else medians(i) = minHeap.head
    }
    medians
  }
}
