package dcp.problems._1_20

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem19_MinCostTest extends AnyFlatSpecLike with Matchers {

  "MinCost" should "should return the minimum cost" in {
    val costs = Array(
      Array(2, 1, 1),
      Array(1, 10, 3),
      Array(1, 2, 100)
    )
    Problem19_MinCost.solution(costs) should be(4)
  }

}
