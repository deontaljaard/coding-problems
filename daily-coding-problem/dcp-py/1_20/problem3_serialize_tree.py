"""

This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s),
 which deserializes the string back into the tree.

The following test should pass:
```text
node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
"""

import json


class Node:

    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def serialize(node):
    if not node:
        return None

    body = {}
    serialized_left = serialize(node.left)
    serialized_right = serialize(node.right)

    body['val'] = node.val
    if serialized_left:
        body['left'] = serialized_left
    if serialized_right:
        body['right'] = serialized_right

    return json.dumps(body)


def deserialize(node_as_str):
    body = json.loads(node_as_str)

    deserialized_node = Node(body.get('val'))
    if 'left' in body:
        deserialized_node.left = deserialize(body.get('left'))
    if 'right' in body:
        deserialized_node.right = deserialize(body.get('right'))

    return deserialized_node


node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
