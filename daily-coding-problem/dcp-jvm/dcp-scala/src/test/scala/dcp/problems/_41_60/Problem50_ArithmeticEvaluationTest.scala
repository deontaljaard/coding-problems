package dcp.problems._41_60

import dcp.problems._41_60.Problem50_ArithmeticEvaluation.Tree
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem50_ArithmeticEvaluationTest extends AnyFlatSpecLike with Matchers {

  val left: Tree = Tree('+',
    left = Tree('3'),
    right = Tree('2'))
  val right: Tree = Tree('+',
    left = Tree('4'),
    right = Tree('5'))
  val tree: Tree = Tree('*',
    left = left,
    right = right
  )

  "ArithmeticEvaluation" should "evaluate an arithmetic expression written as a binary tree" in {
    Problem50_ArithmeticEvaluation.evaluate(left) should be(5)
    Problem50_ArithmeticEvaluation.evaluate(right) should be(9)
    Problem50_ArithmeticEvaluation.evaluate(tree) should be(45)
  }

}
