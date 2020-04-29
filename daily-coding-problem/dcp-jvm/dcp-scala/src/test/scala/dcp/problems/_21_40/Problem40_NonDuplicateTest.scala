package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem40_NonDuplicateTest extends AnyFlatSpecLike with Matchers {

  "NonDuplicate" should "return the non-duplicated integer" in {
    Problem40_NonDuplicate.solution(Array(6, 1, 3, 3, 3, 6, 6)) should be(1)
    Problem40_NonDuplicate.solution(Array(13, 19, 13, 13)) should be(19)

    Problem40_NonDuplicate.solution2(Array(6, 1, 3, 3, 3, 6, 6)) should be(1)
    Problem40_NonDuplicate.solution2(Array(13, 19, 13, 13)) should be(19)
  }

}
