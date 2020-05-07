"""
This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:
```text
   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
```
"""


class Tree:

    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


def unival_subtree_count(tree):
    if not tree:
        return 0
    else:
        count, _ = calc_uni(tree)
        return count


def calc_uni(tree):
    if not tree:
        return 0, True

    left_cnt, is_left_uni = calc_uni(tree.left)
    right_cnt, is_right_uni = calc_uni(tree.right)
    total_cnt = left_cnt + right_cnt
    if is_left_uni and is_right_uni:
        if tree.left and tree.data != tree.left.data:
            return total_cnt, False
        elif tree.right and tree.data != tree.right.data:
            return total_cnt, False
        else:
            return total_cnt + 1, True
    else:
        return total_cnt, False


tree1 = Tree(5,
             left=Tree(1,
                       left=Tree(5),
                       right=Tree(5)),
             right=Tree(5,
                        right=Tree(5)))

assert unival_subtree_count(tree1) == 4

tree2 = Tree(0,
             left=Tree(1),
             right=Tree(0,
                        left=Tree(1,
                                  left=Tree(1),
                                  right=Tree(1)),
                        right=Tree(0)))
assert unival_subtree_count(tree2) == 5
