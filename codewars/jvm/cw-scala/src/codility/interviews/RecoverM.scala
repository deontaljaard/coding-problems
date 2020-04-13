package codility.interviews

object RecoverM {

  def solution(u: Int, l: Int, c: Array[Int]): String = {
    if (u + l > c.sum) return "IMPOSSIBLE"

    var row1Count = u
    var row2Count = l
    val board = Array.ofDim[Int](2, c.length)
    println(c.zipWithIndex.toList)
    c.indices.zip(c).foreach { case (idx, colSum) =>
      val (row1, row2) = if (colSum == 2) {
        row1Count -= 1
        row2Count -= 1
        (1, 1)
      } else if (colSum == 1) {
        if(row1Count > 0) {
          row1Count -= 1
          (1, 0)
        } else {
          row2Count -= 1
          (0, 1)
        }
      } else (0, 0)
      board(0)(idx) = row1
      board(1)(idx) = row2
    }

    //TODO: range check
    board.map(_.mkString("")).mkString(",")
  }

  def main(args: Array[String]): Unit = {
    assert(solution(3, 2, Array(2, 1, 1, 0, 1)) == "11100,10001")
    assert(solution(2, 3, Array(0, 0, 1, 1, 2)) == "IMPOSSIBLE")
    assert(solution(2, 2, Array(2, 0, 2, 0)) == "1010,1010")
  }
}
