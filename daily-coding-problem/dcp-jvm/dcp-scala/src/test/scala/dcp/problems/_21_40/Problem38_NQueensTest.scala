package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem38_NQueensTest extends AnyFlatSpecLike with Matchers {

  "NQueens" should "returns the number of possible arrangements of the board where N queens can be placed on the " +
    "board without threatening each other" in {
    Problem38_NQueens.nQueens(0) should be(1)
    Problem38_NQueens.nQueens(1) should be(1)
    Problem38_NQueens.nQueens(2) should be(0)
    Problem38_NQueens.nQueens(3) should be(0)
    Problem38_NQueens.nQueens(4) should be(2)
    Problem38_NQueens.nQueens(5) should be(10)
    Problem38_NQueens.nQueens(6) should be(4)
    Problem38_NQueens.nQueens(7) should be(40)
    Problem38_NQueens.nQueens(8) should be(92)
    Problem38_NQueens.nQueens(9) should be(352)
  }

}
