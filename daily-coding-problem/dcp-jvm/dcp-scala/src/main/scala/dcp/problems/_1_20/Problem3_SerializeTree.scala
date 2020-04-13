package dcp.problems._1_20

import scala.util.matching.Regex

/**
 * This problem was asked by Google.
 *
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
 * and deserialize(s), which deserializes the string back into the tree.
 */


object Problem3_SerializeTree {

  // recursive type
  case class Node(value: String, left: Option[Node], right: Option[Node]) {
    override def toString = s"""Node("$value",${left.getOrElse(None)},${right.getOrElse(None)})"""
  }

  val serializedFormat: Regex = """Node\("((?:[^"]|\\")*)",(None|Node\(.*\)),(None|Node\(.*\))\)""".r

  def deserialize(nodeAsStr: String): Option[Node] = nodeAsStr match {
    case serializedFormat(value, left, right) => Some(
      Node(
        value,
        if (left == "None") None else deserialize(left),
        if (right == "None") None else deserialize(right)
      )
    )
  }
}
