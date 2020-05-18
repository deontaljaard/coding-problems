package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem56_GraphColouringTest extends AnyFlatSpecLike with Matchers {

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

  "GraphColouring" should "determine whether each vertex in the graph can be colored such that no two adjacent vertices share the same color using at most k colors" in {
    Problem56_GraphColouring.colorable(graph1, 4) should be(true)
  }
}
