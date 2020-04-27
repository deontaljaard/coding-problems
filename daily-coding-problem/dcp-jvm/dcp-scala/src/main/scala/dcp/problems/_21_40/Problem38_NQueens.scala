package dcp.problems._21_40

import scala.collection.mutable

/**
 * This problem was asked by Microsoft.
 *
 * You have an N by N board. Write a function that, given N, returns the number of possible arrangements of the board
 * where N queens can be placed on the board without threatening each other, i.e. no two queens share the same row,
 * column, or diagonal.
 *
 * Reference: https://www.dailycodingproblem.com/blog/an-introduction-to-backtracking/
 */

object Problem38_NQueens {

  def nQueens(N: Int, board: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer.empty[Int]): Int = {
    if (N == board.size) 1
    else {
      var count = 0
      for (col <- 0 until N) {
        board.append(col)
        if (isValid(board))
          count += nQueens(N, board)
        board.remove(board.length - 1)
      }
      count
    }
  }

  def isValid(board: mutable.ArrayBuffer[Int]): Boolean = {
    val (currentQueenRow, currentQueenCol) = (board.length - 1, board(board.length - 1))
    for ((col, row) <- board.slice(0, board.length - 1).zipWithIndex) {
      val diff = math.abs(currentQueenCol - col)
      if (diff == 0 || diff == currentQueenRow - row) return false
    }
    true
  }
}
