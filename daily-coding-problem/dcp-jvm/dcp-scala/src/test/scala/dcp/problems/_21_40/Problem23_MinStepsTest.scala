package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem23_MinStepsTest extends AnyFlatSpecLike with Matchers {

  "MinSteps" should "should return the minimum amount of steps" in {
    val board = Array(
      Array(false, false, false, false),
      Array(true, true, false, true),
      Array(false, false, false, false),
      Array(false, false, false, false)
    )
    Problem23_MinSteps.find(board, (3, 0), (0, 0)) should be(7)
  }

}
