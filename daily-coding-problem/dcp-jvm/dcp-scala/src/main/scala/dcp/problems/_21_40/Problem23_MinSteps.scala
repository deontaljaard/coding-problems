package dcp.problems._21_40

import scala.collection.mutable

/**
 * This problem was asked by Google.
 *
 * You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall.
 * Each False boolean represents a tile you can walk on.
 *
 * Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach
 * the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and
 * right. You cannot move through walls. You cannot wrap around the edges of the board.
 *
 * For example, given the following board:
 *
 * [[f, f, f, f],
 * [t, t, f, t],
 * [f, f, f, f],
 * [f, f, f, f]]
 *
 * and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end
 * is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
 */

object Problem23_MinSteps {

  type Coordinate = (Int, Int)

  case class Point(distance: Int, coordinate: Coordinate)

  val X = List(-1, 0, 1, 0)
  val Y = List(0, 1, 0, -1)

  def isValid[A](point: Coordinate, board: Array[Array[A]]): Boolean = {
    val (x, y) = point
    x >= 0 && x < board.length && y >= 0 && y < board(0).length
  }

  def find(board: Array[Array[Boolean]], start: Coordinate, end: Coordinate): Int = {
    val q = mutable.Queue[Point]()
    val visited = mutable.Set(start)
    q.enqueue(Point(0, start))

    while (q.nonEmpty) {
      val currPoint = q.dequeue()
      if (currPoint.coordinate == end) return currPoint.distance

      for (idx <- 0 to 3) {
        val (currX, currY) = currPoint.coordinate
        val neighbour = (currX + X(idx), currY + Y(idx))
        val (neighbourX, neighbourY) = neighbour
        if (isValid(neighbour, board) && !visited.contains(neighbour) && !board(neighbourX)(neighbourY)) {
          q.enqueue(Point(currPoint.distance + 1, neighbour))
          visited.add(neighbour)
        }
      }
    }
    0
  }

}
