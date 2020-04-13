package dcp.problems._1_20

import Problem8_UnivalSubtreeCount.Tree
import dcp.problems._1_20.Problem8_UnivalSubtreeCount.Tree
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem8_UnivalSubtreeCountTest extends AnyFlatSpecLike with Matchers {

  "UnivalSubtreeCount" should "be able to count unival subtrees" in {
    val tree1: Tree[Int] = Tree(5, left = Tree(1, left = Tree(5), right = Tree(5)), right = Tree(5, right = Tree(5)))
    Problem8_UnivalSubtreeCount.solution(tree1) should be(4)

    val tree2: Tree[Int] = Tree(0, left = Tree(1), right = Tree(0, left = Tree(1, left = Tree(1), right = Tree(1)), right = Tree(0)))
    Problem8_UnivalSubtreeCount.solution(tree2) should be(5)
  }

}
