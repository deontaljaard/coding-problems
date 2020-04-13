package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem21_OverlappingIntervalsTest extends AnyFlatSpecLike with Matchers {

  "OverlappingIntervals" should "should return the minimum amount of rooms" in {
    Problem21_OverlappingIntervals.solution(Array((30, 75), (0, 50), (60, 150))) should be(2)
  }

}
