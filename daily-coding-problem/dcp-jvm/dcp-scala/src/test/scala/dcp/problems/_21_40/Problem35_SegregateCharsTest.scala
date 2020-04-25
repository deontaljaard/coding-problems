package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem35_SegregateCharsTest extends AnyFlatSpecLike with Matchers {

  "SegregateChars" should "segregate the values of the array so that all the Rs come first, the Gs come second, " +
    "and the Bs come last" in {
    Problem35_SegregateChars.solution(Array('G', 'B', 'R', 'R', 'B', 'R', 'G')) should be(Array('R', 'R', 'R', 'G', 'G', 'B', 'B'))
  }

}
