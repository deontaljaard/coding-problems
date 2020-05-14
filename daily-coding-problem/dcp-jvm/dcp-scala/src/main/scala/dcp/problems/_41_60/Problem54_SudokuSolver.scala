package dcp.problems._41_60

/**
 * This problem was asked by Dropbox.
 *
 * Sudoku is a puzzle where you're given a partially-filled 9 by 9 grid with digits. The objective is to fill the grid
 * with the constraint that every row, column, and box (3 by 3 subgrid) must contain all of the digits from 1 to 9.
 *
 * Implement an efficient sudoku solver.
 *
 * Reference: http://see.stanford.edu/materials/icspacs106b/H19-RecBacktrackExamples.pdf
 */

object Problem54_SudokuSolver extends App {

  type Cell = (Int, Int)
  val allAssigned: Cell = (-1, -1)
  val squareSize = 3
  val boardSize = 9

  def solvePuzzle(grid: Array[Array[Int]]): Boolean = {
    val result = findUnassignedCell(grid)
    if (result == allAssigned) return true

    val (row, col) = result
    for (num <- 1 to boardSize) {
      if (noConflicts(grid, row, col, num)) {
        grid(row)(col) = num
        if (solvePuzzle(grid)) return true
        grid(row)(col) = 0
      }
    }
    false
  }

  private def findUnassignedCell(grid: Array[Array[Int]]): Cell = {
    val unassigned = for (r <- 0 until boardSize; c <- 0 until boardSize; if (grid(r)(c) == 0)) yield (r, c)
    unassigned.headOption.getOrElse(allAssigned)
  }

  private def noConflicts(grid: Array[Array[Int]], row: Int, col: Int, num: Int): Boolean =
    !usedInRow(grid, row, num) && !usedInCol(grid, col, num) && !usedInSquare(grid, row - row % 3, col - col % 3, num)

  private def usedInRow(grid: Array[Array[Int]], row: Int, num: Int): Boolean =
    grid(row).contains(num)

  private def usedInCol(grid: Array[Array[Int]], col: Int, num: Int): Boolean = {
    val transposedGrid = grid.transpose
    transposedGrid(col).contains(num)
  }

  private def usedInSquare(grid: Array[Array[Int]], rowStart: Int, colStart: Int, num: Int): Boolean = {
    val squareAsRow = Array.range(0, squareSize).flatMap { i =>
      grid(rowStart + i).slice(colStart, colStart + squareSize)
    }
    squareAsRow.contains(num)
  }

  val puzzle =
    Array(
      Array(0, 5, 0, 3, 0, 9, 0, 2, 6),
      Array(3, 8, 9, 4, 2, 0, 1, 5, 7),
      Array(4, 0, 6, 1, 0, 0, 0, 8, 9),
      Array(0, 1, 3, 7, 9, 8, 0, 0, 4),
      Array(0, 0, 8, 0, 0, 0, 5, 0, 0),
      Array(0, 6, 0, 0, 0, 3, 0, 0, 0),
      Array(0, 0, 1, 9, 3, 0, 0, 4, 0),
      Array(9, 3, 5, 6, 4, 0, 8, 0, 1),
      Array(0, 0, 2, 8, 7, 0, 0, 0, 5)
    )

  val solvedPuzzle =
    Array(
      Array(1, 5, 7, 3, 8, 9, 4, 2, 6),
      Array(3, 8, 9, 4, 2, 6, 1, 5, 7),
      Array(4, 2, 6, 1, 5, 7, 3, 8, 9),
      Array(5, 1, 3, 7, 9, 8, 2, 6, 4),
      Array(7, 9, 8, 2, 6, 4, 5, 1, 3),
      Array(2, 6, 4, 5, 1, 3, 7, 9, 8),
      Array(8, 7, 1, 9, 3, 5, 6, 4, 2),
      Array(9, 3, 5, 6, 4, 2, 8, 7, 1),
      Array(6, 4, 2, 8, 7, 1, 9, 3, 5)
    )

  solvePuzzle(puzzle)
  for (row <- 0 until boardSize) {
    assert(puzzle(row) sameElements solvedPuzzle(row))
  }
}
