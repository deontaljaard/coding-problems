package dcp.problems._1_20

import Problem3_SerializeTree.Node
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem3_SerializeTreeTest extends AnyFlatSpecLike with Matchers {

  val tree: Node = Node("root",
    Some(Node("left",
      Some(Node("left.left", None, None)),
      None)),
    Some(Node("right", None, None))
  )

  "SerializeTree" should "serialize a tree" in {
    tree.toString should be("Node(\"root\",Node(\"left\",Node(\"left.left\",None,None),None),Node(\"right\",None,None))")
  }

  it should "deserialize a tree" in {
    val serialized = "Node(\"root\",Node(\"left\",Node(\"left.left\",None,None),None),Node(\"right\",None,None))"
    Problem3_SerializeTree.deserialize(serialized).get should be(tree)
  }
}
