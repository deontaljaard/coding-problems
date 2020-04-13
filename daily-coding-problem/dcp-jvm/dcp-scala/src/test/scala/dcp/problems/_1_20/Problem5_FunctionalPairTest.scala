package dcp.problems._1_20

import Problem5_FunctionalPair._
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem5_FunctionalPairTest extends AnyFlatSpecLike with Matchers {

  "FunctionalPair" should "return tuple[a, b] => a for car()" in {
    car(cons(3, 4)) should be(3)
  }

  it should "return tuple[a, b] => b for cdr()" in {
    cdr(cons(3, 4)) should be(4)
  }
}
