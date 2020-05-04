package dcp.problems._41_60

import scala.util.Random

/**
 * This problem was asked by Two Sigma.
 *
 * Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, implement a
 * function rand7() that returns an integer from 1 to 7 (inclusive).
 *
 * Reference: https://www.geeksforgeeks.org/generate-integer-from-1-to-7-with-equal-probability/
 */

object Problem45_Rand7 {
  val r = new Random()

  def rand5(): Int = 1 + r.nextInt(5)

  @scala.annotation.tailrec
  def rand7(): Int = {
    val i = 5 * rand5() + rand5() - 5
    if (i < 22) i % 7 + 1
    else rand7()
  }
}
