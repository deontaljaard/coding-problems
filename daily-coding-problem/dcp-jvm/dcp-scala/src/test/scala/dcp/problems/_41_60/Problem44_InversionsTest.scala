package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem44_InversionsTest extends AnyFlatSpecLike with Matchers {

  "Inversions" should "return the count of inversions in an array" in {
    Problem44_Inversions.inversions(Array(2, 4, 1, 3, 5)) should be(3)
    Problem44_Inversions.inversions(Array(5, 4, 3, 2, 1)) should be(10)

    Problem44_Inversions.inversions_2(Array(2, 4, 1, 3, 5)) should be(3)
    Problem44_Inversions.inversions_2(Array(5, 4, 3, 2, 1)) should be(10)
  }

}
