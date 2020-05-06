package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem47_MaxProfitTest extends AnyFlatSpecLike with Matchers {

  "MaxProfit" should "return the maximum profit you could have made from buying and selling that stock once" in {
    Problem47_MaxProfit.maxProfit(Array(9, 11, 8, 5, 7, 10)) should be(5)
    Problem47_MaxProfit.maxProfit(Array(1, 2, 3, 4, 5)) should be(4)
    Problem47_MaxProfit.maxProfit(Array(10, 7)) should be(-3)
    Problem47_MaxProfit.maxProfit(Array(10)) should be(0)
  }

}
