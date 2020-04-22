package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem32_ArbitrageTest extends AnyFlatSpecLike with Matchers {

  "Arbitrage" should "determine whether there is a possible arbitrage" in {
    //      USD,    EUR,    GBP,    CHF,    CAD
    val rates = Array(
      Array(1.0f,    0.741f,  0.657f,  1.061f,  1.011f), // USD
      Array(1.35f,   1.0f,    0.889f,  1.433f,  1.366f), // EUR
      Array(1.521f,  1.126f,  1.0f,    1.614f,  1.538f), // GBP
      Array(0.943f,  0.698f,  0.62f,   1.0f,    0.953f), // CHF
      Array(0.955f,  0.732f,  0.65f,   1.049f,  1.0f),   // CAD
    )
    Problem32_Arbitrage.solution(rates) should be(true)
  }

}
