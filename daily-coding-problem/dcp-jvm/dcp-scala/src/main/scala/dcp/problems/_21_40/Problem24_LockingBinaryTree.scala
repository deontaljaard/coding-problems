package dcp.problems._21_40

/**
 * This problem was asked by Google.
 *
 * Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or
 * ancestors are not locked.
 *
 * Design a binary tree node class with the following methods: *
 * is_locked, which returns whether the node is locked
 * lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
 * unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
 *
 * You may augment the node to add parent pointers or any other property you would like. You may assume the class is
 * used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h),
 * where h is the height of the tree.
 *
 * Reference: https://www.dailycodingproblem.com/blog/lockable-binary-trees/
 */

object Problem24_LockingBinaryTree {

  class Tree[A](var data: A,
                var parent: Tree[A] = null,
                var left: Tree[A] = null,
                var right: Tree[A] = null,
                var isLocked: Boolean = false,
                var lockedDescendants: Int = 0)

  object Tree {

    def canLockOrUnlock[A](tree: Tree[A]): Boolean = {
      if (tree.lockedDescendants > 0) false
      else {
        var current = tree.parent
        while (current != null) {
          if (current.isLocked) return false
          current = current.parent
        }
        true
      }
    }

    def lock[A](tree: Tree[A]): Boolean = {
      if (canLockOrUnlock(tree)) {
        tree.isLocked = true
        propagate(tree) {
          _.lockedDescendants += 1
        }
        true
      } else false
    }

    def unlock[A](tree: Tree[A]): Boolean = {
      if (canLockOrUnlock(tree)) {
        tree.isLocked = false
        propagate(tree) {
          _.lockedDescendants -= 1
        }
        true
      } else false
    }

    def propagate[A](tree: Tree[A])(fun: Tree[A] => Unit): Unit = {
      var current = tree.parent
      while (current != null) {
        fun(current)
        current = current.parent
      }
    }

  }

}
