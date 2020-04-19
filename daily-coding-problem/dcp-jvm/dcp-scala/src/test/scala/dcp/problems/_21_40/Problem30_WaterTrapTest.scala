package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem30_WaterTrapTest extends AnyFlatSpecLike with Matchers {

  "WaterTrap" should "determine how many of units of water a trap can hold" in {
    Problem30_WaterTrap.solution(Array(1, 1)) should be(0)
    Problem30_WaterTrap.solution(Array(2, 1, 2)) should be(1)
    Problem30_WaterTrap.solution(Array(3, 0, 1, 3, 0, 5)) should be(8)
    Problem30_WaterTrap.solution(Array(5, 0, 6, 1, 2, 5)) should be(12)
  }

}
