package dcp.problems._41_60

import scala.collection.mutable

/**
 * This problem was asked by Microsoft.
 *
 * Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one
 * of '+', '−', '∗', or '/'.
 *
 * Given the root to such a tree, write a function to evaluate it.
 *
 * For example, given the following tree:
 *
 * *
 * / \
 * +    +
 * / \  / \
 * 3  2  4  5
 *
 * You should return 45, as it is (3 + 2) * (4 + 5).
 */

object Problem50_ArithmeticEvaluation extends App {

  case class Tree(data: Char, left: Tree = null, right: Tree = null)

  def evaluate(tree: Tree): Int = tree match {
    case Tree(d, null, null) => d.asDigit
    case Tree('+', l, r) => evaluate(l) + evaluate(r)
    case Tree('-', l, r) => evaluate(l) - evaluate(r)
    case Tree('*', l, r) => evaluate(l) * evaluate(r)
    case Tree('/', l, r) => evaluate(l) / evaluate(r)
  }


}
