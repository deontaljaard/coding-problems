package codility.challenges

import scala.util.Try

object MaxPathFromTheLeftTopCorner {
  def solution(matrix: Array[Array[Int]]): String = {
    @scala.annotation.tailrec
    def calc(startPos: (Int, Int), sequence: String): String = {
      if (startPos == (matrix.length - 1, matrix(0).length - 1)) sequence
      else {
        val down = Try(matrix(startPos._1 + 1)(startPos._2)).getOrElse(0)
        val right = Try(matrix(startPos._1)(startPos._2 + 1)).getOrElse(0)
        val max = math.max(down, right)
        calc(if (max == down) (startPos._1 + 1, startPos._2) else (startPos._1, startPos._2 + 1), sequence + max)
      }
    }
    calc((0, 0), matrix(0)(0).toString)
  }

  def main(args: Array[String]): Unit = {
    assert(solution(Array(
      Array(9, 9, 7),
      Array(9, 7, 2),
      Array(6, 9, 5),
      Array(9, 1, 2),
    )) == "997952")
  }
}
