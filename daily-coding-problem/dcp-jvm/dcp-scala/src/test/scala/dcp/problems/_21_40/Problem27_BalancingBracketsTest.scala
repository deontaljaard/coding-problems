package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem27_BalancingBracketsTest extends AnyFlatSpecLike with Matchers {

  "BalancingBrackets" should "should determine if a string of brackets is well-formed" in {
    Problem27_BalancingBrackets.isBalanced("([])[]({})") should be(true)
    Problem27_BalancingBrackets.isBalanced("([)]") should be(false)
    Problem27_BalancingBrackets.isBalanced("((()") should be(false)
  }

}
