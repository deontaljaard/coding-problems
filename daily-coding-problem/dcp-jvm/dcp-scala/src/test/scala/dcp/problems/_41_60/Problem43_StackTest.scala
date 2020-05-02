package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem43_StackTest extends AnyFlatSpecLike with Matchers {

  "Stack" should "push an element onto the stack" in {
    val stack = new Problem43_Stack.Stack()
    stack.push(1)
    stack.push(2)
    stack.getMemory.nonEmpty should be(true)
    stack.getMemory should be(Array(2, 1))
  }


  "Stack" should " pop off and return the topmost element of the stack" in {
    val stack = new Problem43_Stack.Stack()
    stack.push(1)
    stack.push(2)
    stack.pop() should be(2)
    stack.pop() should be(1)
  }


  "Stack" should "return the maximum value in the stack currently" in {
    val stack = new Problem43_Stack.Stack()
    stack.push(1)
    stack.push(2)
    stack.max should be(2)
    stack.push(5)
    stack.push(10)
    stack.push(4)
    stack.max should be(10)
    stack.pop() should be(4)
    stack.max should be(10)
    stack.pop() should be(10)
    stack.max should be(5)
  }
}
