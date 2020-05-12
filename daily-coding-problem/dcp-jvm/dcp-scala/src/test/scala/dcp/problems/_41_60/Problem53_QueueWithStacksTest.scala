package dcp.problems._41_60

import dcp.problems._41_60.Problem53_QueueWithStacks.Queue
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem53_QueueWithStacksTest extends AnyFlatSpecLike with Matchers {

  "QueueWithStacks" should "should support enqueue and dequeue operations" in {
    val q = new Queue[Char]()
    q.enqueue('a')
    q.enqueue('b')
    q.enqueue('c')

    q.dequeue() should be(Some('a'))
    q.enqueue('d')
    q.dequeue() should be(Some('b'))
    q.dequeue() should be(Some('c'))
    q.dequeue() should be(Some('d'))
  }

}
