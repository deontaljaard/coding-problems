package dcp.problems._21_40

import scala.collection.mutable

/**
 * This problem was asked by Facebook.
 *
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced
 * (well-formed).
 *
 * For example, given the string "([])[]({})", you should return true.
 *
 * Given the string "([)]" or "((()", you should return false.
 */

object Problem27_BalancingBrackets {

  val openBrackets = Set('(', '{', '[')

  def isBalanced(brackets: String): Boolean = {
    val stack = mutable.Stack[Char]()
    for (bracket <- brackets) {
      if (openBrackets.contains(bracket)) stack.push(bracket)
      else if (bracket == ')' && stack.pop() != '(') return false
      else if (bracket == '}' && stack.pop() != '{') return false
      else if (bracket == ']' && stack.pop() != '[') return false
    }
    stack.isEmpty
  }
}
