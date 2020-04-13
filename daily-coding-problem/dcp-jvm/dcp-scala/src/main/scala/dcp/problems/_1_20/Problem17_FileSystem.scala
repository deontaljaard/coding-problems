package dcp.problems._1_20

import scala.collection.mutable

/**
 * This problem was asked by Google.
 *
 * Suppose we represent our file system by a string in the following manner:
 *
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 *
 * dir
 * subdir1
 * subdir2
 *         file.ext
 *
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
 *
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 *
 * dir
 * subdir1
 * file1.ext
 * subsubdir1
 * subdir2
 * subsubdir2
 * file2.ext
 *
 * The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty
 * second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file
 * file2.ext.
 *
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system. For
 * example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length
 * is 32 (not including the double quotes).
 *
 * Given a string representing the file system in the above format, return the length of the longest absolute path to a
 * file in the abstracted file system. If there is no file in the system, return 0.
 *
 * Note:
 *
 * The name of a file contains at least a period and an extension.
 *
 * The name of a directory or sub-directory will not contain a period.
 */

object Problem17_FileSystem {


  def parse(fileSystem: String): Int = {
    val fileNodes = fileSystem.split("\n")
    if (fileNodes.isEmpty) return 0

    val pathStack: mutable.Stack[String] = mutable.Stack[String]()
    pathStack.push(fileNodes.head)

    var longestPath = fileNodes.head
    var longestPathLength = longestPath.length
    var currentDepth = 0

    for (node <- fileNodes.tail) {
      val currentLevelDepth = node.count(_ == '\t')
      val fileObject = node.replace("\t", "")
      if (fileObject.contains(".")) {
        if (currentLevelDepth != currentDepth + 1) {
          val depthDifference = math.abs(currentDepth - currentLevelDepth)
          (0 to depthDifference).foreach { _ => pathStack.pop(); currentDepth -= 1 }
        }

        if (pathStack.mkString("").length + node.length > longestPathLength) {
          longestPath = pathStack.toList.reverse.mkString("/") + s"/$node"
          longestPathLength = longestPath.length
        }
      } else {
        if (currentLevelDepth != currentDepth + 1) {
          val depthDifference = math.abs(currentDepth - currentLevelDepth)
          (0 to depthDifference).foreach { _ => pathStack.pop(); currentDepth -= 1 }
        }

        pathStack.push(node)
        currentDepth += 1
      }
    }

    val value = s"${longestPath.replace("\t", "")}"
    value.length
  }

  def main(args: Array[String]): Unit = {
    val fs = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
    val fs2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
    println(parse(fs2))
  }
}
