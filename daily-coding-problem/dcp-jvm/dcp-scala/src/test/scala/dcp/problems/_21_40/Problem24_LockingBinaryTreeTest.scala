package dcp.problems._21_40

import dcp.problems._21_40.Problem24_LockingBinaryTree.Tree
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem24_LockingBinaryTreeTest extends AnyFlatSpecLike with Matchers {

  "LockingBinaryTree" should "should confirm a node in the tree can be locked" in {
    val root = new Tree(3)
    val left = new Tree(1, parent = root)
    val right = new Tree(2, parent = root)
    Tree.canLockOrUnlock(root) should be(true)
    Tree.lock(left) should be(true)
    Tree.canLockOrUnlock(root) should be(false)
    root.lockedDescendants should be(1)
    Tree.unlock(left) should be(true)
    Tree.lock(root) should be(true)
    Tree.lock(right) should be(false)
  }

}
