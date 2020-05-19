package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem58_FindIndexTest extends AnyFlatSpecLike with Matchers {

  "FindIndex" should "find the index of the element in the array in faster than linear time" in {
    Problem58_FindIndex.findIndex(Array(13, 18, 25, 2, 8, 10), 2) == 3
    Problem58_FindIndex.findIndex(Array(13, 18, 25, 2, 8, 10), 8) == 4
    Problem58_FindIndex.findIndex(Array(25, 2, 8, 10, 13, 18), 8) == 2
    Problem58_FindIndex.findIndex(Array(8, 10, 13, 18, 25, 2), 8) == 0
  }
}
