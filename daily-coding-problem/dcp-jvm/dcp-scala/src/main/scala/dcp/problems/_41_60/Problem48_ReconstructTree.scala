package dcp.problems._41_60

/**
 * This problem was asked by Google.
 *
 * Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.
 *
 * For example, given the following preorder traversal:
 *
 * [a, b, d, e, c, f, g]
 *
 * And the following inorder traversal:
 *
 * [d, b, e, a, f, c, g]
 *
 * You should return the following tree:
 *
 * a
 * / \
 * b   c
 * / \ / \
 * d  e f  g
 */

object Problem48_ReconstructTree {

  class Tree(val data: Char, var left: Tree = null, var right: Tree = null)

  def construct(preorder: Array[Char], inorder: Array[Char]): Tree = {
    var preIdx = 0

    def search(low: Int, key: Char) = {
      var idx = low
      while (inorder(idx) != key) idx += 1
      idx
    }

    def buildTreeRec(low: Int, high: Int): Tree = {
      if (low > high) return null
      val root = new Tree(preorder(preIdx))
      val nodePos = search(low, preorder(preIdx))
      preIdx += 1
      root.left = buildTreeRec(low, nodePos - 1)
      root.right = buildTreeRec(nodePos + 1, high)
      root
    }

    buildTreeRec(0, inorder.length - 1)
  }
}
