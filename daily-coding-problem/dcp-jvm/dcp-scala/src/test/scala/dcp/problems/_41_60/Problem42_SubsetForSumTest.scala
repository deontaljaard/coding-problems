package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem42_SubsetForSumTest extends AnyFlatSpecLike with Matchers {

  "SubsetForSum" should "returns a subset of S that adds up to k" in {
    Problem42_SubsetForSum.subsetForSum(List(), 0) should be(Nil)
    Problem42_SubsetForSum.subsetForSum(List(12, 1, 61, 5, 9, 2), 24) should be(List(12, 1, 9, 2))
    Problem42_SubsetForSum.subsetForSum(List(2, 2, 4, 2, 8), 12) should be(List(2, 2, 8))
  }

}
