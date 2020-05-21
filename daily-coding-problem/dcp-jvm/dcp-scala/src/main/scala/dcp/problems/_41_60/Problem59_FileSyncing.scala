package dcp.problems._41_60

/**
 * This problem was asked by Google.
 *
 * Implement a file syncing algorithm for two computers over a low-bandwidth network. What if we know the files in the
 * two computers are mostly the same?
 *
 * Reference: https://en.wikipedia.org/wiki/Merkle_tree
 */

import java.security.MessageDigest

object Problem59_FileSyncing extends App {

  val sha256: String => String =
    data => MessageDigest.getInstance("SHA-256").digest(data.getBytes()).map("%02x".format(_)).mkString

  class MerkleTree(var data: String, var left: MerkleTree = null, var right: MerkleTree = null)

  object MerkleTree {
    def apply(data: List[String], hashFn: String => String = sha256): MerkleTree = {
      @scala.annotation.tailrec
      def buildTree(nodes: List[MerkleTree]): MerkleTree = nodes match {
        case ns if ns.length <= 1 => ns.head
        case ns =>
          val treePair = ns.grouped(2).map {
            case a :: Nil => new MerkleTree(hashFn(a.data), a)
            case a :: b :: Nil => new MerkleTree(hashFn(a.data + b.data), a, b)
          }.toList
          buildTree(treePair)
      }

      if (data.isEmpty) new MerkleTree(hashFn(""))
      else {
        val nodes = data.map(d => new MerkleTree(hashFn(d)))
        buildTree(nodes)
      }
    }
  }

  def detectChange(refNode: MerkleTree, newNode: MerkleTree): Boolean = {
    if (refNode == null && newNode == null) false
    else if (refNode == null || newNode == null) true
    else {
      val leftChange = detectChange(refNode.left, newNode.left)
      val rightChange = detectChange(refNode.right, newNode.right)
      if (refNode.data != newNode.data) {
        println(s"Change detected. Root hash ${newNode.data}")
        true
      } else leftChange || rightChange
    }
  }

  def mergeChange(refNode: MerkleTree, newNode: MerkleTree): MerkleTree = {
    if (refNode == null && newNode == null) return null
    else if (refNode != null && newNode == null) {
      println("Change detected: Change - DELETED")
      return null
    } else if (refNode == null && newNode != null) {
      println("Change detected: Change - ADDED")
      return newNode
    } else if(refNode.data != newNode.data) {
      refNode.data = newNode.data
    }
    refNode.left = mergeChange(refNode.left, newNode.left)
    refNode.right = mergeChange(refNode.right, newNode.right)
    refNode
  }

  val file1 = List("A", "B", "C", "D", "E")
  val file2 = "AA" +: file1.tail

  var fileSystemA = MerkleTree(file1)
  val fileSystemB = MerkleTree(file2)

  assert(fileSystemA.data != fileSystemB.data)
  if (detectChange(fileSystemA, fileSystemB)) {
    fileSystemA = mergeChange(fileSystemA, fileSystemB)
  }
  assert(fileSystemA.data == fileSystemB.data)
}
