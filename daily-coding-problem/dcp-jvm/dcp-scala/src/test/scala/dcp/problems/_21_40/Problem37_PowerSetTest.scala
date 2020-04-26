package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem37_PowerSetTest extends AnyFlatSpecLike with Matchers {

  "PowerSet" should "generate a power set" in {
    val res1 = Set(Set())
    val res2 = Set(Set(), Set(1))
    val res3 = Set(Set.empty, Set(1), Set(2), Set(3), Set(1, 2), Set(1, 3), Set(2, 3), Set(1, 2, 3))
    val res4 = Set(Set.empty, Set(1), Set(2), Set(3), Set(4), Set(1, 2), Set(1, 3), Set(1, 4),
      Set(2, 3), Set(2, 4), Set(3, 4), Set(1, 2, 3), Set(1, 3, 4), Set(1, 2, 4), Set(2, 3, 4), Set(1, 2, 3, 4))

    Problem37_PowerSet.solution(Set()) should be(res1)
    Problem37_PowerSet.solution(Set(1)) should be(res2)
    Problem37_PowerSet.solution(Set(1, 2, 3)) should be(res3)
    Problem37_PowerSet.solution(Set(1, 2, 3, 4)) should be(res4)

    Problem37_PowerSet.solution2(Set()) should be(res1)
    Problem37_PowerSet.solution2(Set(1)) should be(res2)
    Problem37_PowerSet.solution2(Set(1, 2, 3)) should be(res3)
    Problem37_PowerSet.solution2(Set(1, 2, 3, 4)) should be(res4)
  }

}
