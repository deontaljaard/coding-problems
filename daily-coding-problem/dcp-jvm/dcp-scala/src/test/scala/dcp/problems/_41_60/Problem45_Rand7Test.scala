package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem45_Rand7Test extends AnyFlatSpecLike with Matchers {

  "Rand5" should "return an integer from 1 to 5" in {
    for (_ <- 0 until 10000) {
      val i = Problem45_Rand7.rand5()
      i should be >= 1
      i should be <= 5
    }
  }

  def round(value: Double, precision: Int): Double = BigDecimal(value).setScale(precision, BigDecimal.RoundingMode.HALF_UP).toDouble

  "Rand7" should "return an integer from 1 to 7" in {
    val experiments = 10000
    val distribution = (0 until experiments).foldLeft(Map.empty[Int, Int]) { case (acc, _) =>
      val num = Problem45_Rand7.rand7()
      val i = acc.getOrElse(num, 1) + 1
      acc + (num -> i)
    }

    val probability = 1.0 / 7.0
    val desiredProbability = round(probability, 2)
    val variance = 0.01
    for ((_, count) <- distribution) {
      val i = count.toDouble / experiments.toDouble
      round(i, 2) should be <= desiredProbability + variance
    }
  }

}
