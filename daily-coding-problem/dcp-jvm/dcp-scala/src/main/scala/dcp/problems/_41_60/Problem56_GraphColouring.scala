package dcp.problems._41_60

/**
 * This problem was asked by Google.
 *
 * Given an undirected graph represented as an adjacency matrix and an integer k, write a function to determine whether
 * each vertex in the graph can be colored such that no two adjacent vertices share the same color using at most k
 * colors.
 */

object Problem56_GraphColouring  {

  def colorable(graph: Array[Array[Int]], colours: Int): Boolean = {
    val maxAdjacentVertices = graph.foldLeft(0) { case (maxAdjacentVertices, row) => math.max(maxAdjacentVertices, row.sum) }
    colours > maxAdjacentVertices
  }

  val graph1 = Array(
    Array(0, 1, 1, 1),
    Array(1, 0, 1, 1),
    Array(1, 1, 0, 1),
    Array(1, 1, 1, 0)
  )

  val graph2 = Array(
    Array(0, 0, 0, 0),
    Array(0, 0, 0, 0),
    Array(0, 0, 0, 0),
    Array(0, 0, 0, 0)
  )

  val graph3 = Array(
    Array(0, 1, 1, 1),
    Array(1, 0, 1, 0),
    Array(1, 1, 0, 1),
    Array(1, 0, 1, 0)
  )

  assert(colorable(graph1, 4))
}
