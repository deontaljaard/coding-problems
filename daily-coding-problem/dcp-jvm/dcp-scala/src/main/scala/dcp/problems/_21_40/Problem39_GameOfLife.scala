package dcp.problems._21_40

/**
 * This problem was asked by Dropbox.
 *
 * Conway's Game of Life takes place on an infinite two-dimensional board of square cells. Each cell is either dead or
 * alive, and at each tick, the following rules apply:
 *
 * Any live cell with less than two live neighbours dies.
 * Any live cell with two or three live neighbours remains living.
 * Any live cell with more than three live neighbours dies.
 * Any dead cell with exactly three live neighbours becomes a live cell.
 *
 * A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.
 *
 * Implement Conway's Game of Life. It should be able to be initialized with a starting list of live cell coordinates
 * and the number of steps it should run for. Once initialized, it should print out the board state at each step. Since
 * it's an infinite board, print out only the relevant coordinates, i.e. from the top-leftmost live cell to
 * bottom-rightmost live cell.
 *
 * You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).
 */

object Problem39_GameOfLife extends App {

  private val cellRange = -1 to 1

  case class Cell(x: Int, y: Int) {
    def neighbours: Seq[Cell] =
      for (x <- cellRange; y <- cellRange if (x != 0 || y != 0)) yield this.copy(x = this.x + x, y = this.y + y)
  }

  case class Iteration(deadCells: List[Cell], livenessNeighbourhood: Map[Cell, Int]) {
    def processCell(cell: Cell, liveCells: List[Cell]): Iteration = {
      val neighbours = cell.neighbours
      val numLiveCells = liveCells.count(neighbours.contains)
      val isDead = numLiveCells < 2 || numLiveCells > 3

      val neighbourhood = neighbours.foldLeft(this.livenessNeighbourhood) { case (acc, cell) =>
        val count = acc.getOrElse(cell, 0) + 1
        acc + (cell -> count)
      }

      this.copy(
        deadCells = if (isDead) this.deadCells :+ cell else Nil,
        livenessNeighbourhood = neighbourhood)
    }
  }

  object Iteration {
    def empty: Iteration = Iteration(deadCells = List.empty[Cell], livenessNeighbourhood = Map.empty[Cell, Int])
  }

  case class GameOfLife(liveCells: List[Cell], printBoard: Boolean = false) {
    def step: GameOfLife = {
      val iteration = liveCells.foldLeft(Iteration.empty) { case (accIteration, cell) => accIteration.processCell(cell, liveCells) }
      val combinedLiveCells: List[Cell] = liveCells ++ iteration.livenessNeighbourhood.collect { case (cell, count) if count == 3 => cell }.toList
      val newLiveCells = combinedLiveCells.toSet.filter(cell => !iteration.deadCells.contains(cell)).toList
      val gameOfLife = this.copy(liveCells = newLiveCells)
      if (printBoard) println(gameOfLife)
      gameOfLife
    }

    override def toString: String = {
      if (liveCells.isEmpty) "."
      else {
        var (minX, minY, maxX, maxY) = (Int.MaxValue, Int.MaxValue, -Int.MaxValue, -Int.MaxValue)
        for (cell <- liveCells) {
          if (cell.x < minX) minX = cell.x
          if (cell.x > maxX) maxX = cell.x
          if (cell.y < minY) minY = cell.y
          if (cell.y > maxY) maxY = cell.y
        }

        val rows = maxX - minX + 1
        val cols = maxY - minY + 1
        val board = Array.ofDim[Char](rows, cols)
        for (r <- board.indices; c <- board(0).indices) board(r)(c) = '.'
        for (cell <- liveCells) board(cell.x - minX)(cell.y - minY) = '*'

        board.foldLeft("") { case (acc, row) => acc + row.mkString(" ") + "\n" }
      }
    }
  }

  object GameOfLife {
    def runWith(liveCells: List[Cell], steps: Int, printBoard: Boolean = false): GameOfLife = {
      println("Starting with initial board (step #0):")
      val game = GameOfLife(liveCells, printBoard)
      println(game)
      (0 until steps).foldLeft(game) { case (accGame, step) =>
        if (printBoard) println(s"Step #${step + 1}:")
        accGame.step
      }
    }
  }

  GameOfLife.runWith(
    liveCells = List(Cell(0, 0), Cell(1, 0), Cell(1, 1), Cell(1, 5)),
    steps = 3,
    printBoard = true)

  GameOfLife.runWith(
    liveCells = List(Cell(0, 0), Cell(1, 0), Cell(1, 1), Cell(1, 5), Cell(2, 5), Cell(2, 6)),
    steps = 4,
    printBoard = true)

  GameOfLife.runWith(
    liveCells = List(Cell(0, 0), Cell(1, 0), Cell(1, 1), Cell(2, 5), Cell(2, 6), Cell(3, 9), Cell(4, 8), Cell(5, 10)),
    steps = 4,
    printBoard = true)
}
