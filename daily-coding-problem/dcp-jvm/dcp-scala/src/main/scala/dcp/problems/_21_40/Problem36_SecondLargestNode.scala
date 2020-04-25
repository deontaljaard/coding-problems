package dcp.problems._21_40

/**
 * This problem was asked by Dropbox.
 *
 * Given the root to a binary search tree, find the second largest node in the tree.
 */

object Problem36_SecondLargestNode {

  type LargestAndParent[A] = (Tree[A], Tree[A])

  case class Tree[A](data: A, left: Tree[A] = null, right: Tree[A] = null)

  def find2ndLargestN[A](tree: Tree[A]): Tree[A] = {
    @scala.annotation.tailrec
    def findLargestParent(tree: Tree[A], parent: Tree[A]): Tree[A] = tree match {
      case Tree(_, _, null) => parent
      case Tree(_, _, right) => findLargestParent(right, tree)
    }

    tree match {
      case Tree(_, left, null) => findLargestParent(left, tree)
      case Tree(_, _, right) => findLargestParent(right, tree)
      case _ => null
    }
  }

}
