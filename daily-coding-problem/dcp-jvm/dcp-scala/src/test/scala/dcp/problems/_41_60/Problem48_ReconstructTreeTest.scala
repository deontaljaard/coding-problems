package dcp.problems._41_60

import dcp.problems._41_60.Problem48_ReconstructTree.Tree
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem48_ReconstructTreeTest extends AnyFlatSpecLike with Matchers {

  val tree: Tree = new Tree(
    'a',
    left = new Tree('b',
      left = new Tree('d'),
      right = new Tree('e')),
    right = new Tree('c',
      left = new Tree('f'),
      right = new Tree('g'))
  )

  "ReconstructTree" should "given a pre-order and in-order traversal of a tree reconstruct it" in {
    val tree = Problem48_ReconstructTree.construct(Array('a', 'b', 'd', 'e', 'c', 'f', 'g'), Array('d', 'b', 'e', 'a', 'f', 'c', 'g'))
    tree.data should be('a')
    tree.left.data should be('b')
    tree.left.left.data should be('d')
    tree.left.right.data should be('e')
    tree.right.data should be('c')
    tree.right.left.data should be('f')
    tree.right.right.data should be('g')
  }

}
