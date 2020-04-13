package dcp.problems._1_20

/**
 * This problem was asked by Google.
 *
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 *
 * Given the root to a binary tree, count the number of unival subtrees.
 */

object Problem8_UnivalSubtreeCount {

  case class Tree[A](data: A, left: Tree[A] = null, right: Tree[A] = null)

  type CountFlag = (Int, Boolean)

  def solution[A](root: Tree[A]): Int =
    if (root == null) 0
    else {
      val (count, _) = calcUni(root)
      count
    }

  def calcUni[A](root: Tree[A]): CountFlag = {
    if (root == null) return (0, true)
    val (leftCnt, isLeftUni) = calcUni(root.left)
    val (rightCnt, isRightUni) = calcUni(root.right)
    val totalCnt = leftCnt + rightCnt
    if (isLeftUni && isRightUni) {
      if (root.left != null && root.data != root.left.data) (totalCnt, false)
      else if (root.right != null && root.data != root.right.data) (totalCnt, false)
      else (totalCnt + 1, true)
    }
    else (totalCnt, false)
  }

}
