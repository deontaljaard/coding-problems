package dcp.problems._21_40

/**
 * This problem was asked by Jane Street.
 *
 * Suppose you are given a table of currency exchange rates, represented as a 2D array. Determine whether there is a
 * possible arbitrage: that is, whether there is some sequence of trades you can make, starting with some amount A of
 * any currency, so that you can end up with some amount greater than A of that currency.
 *
 * There are no transaction costs and you can trade fractional quantities.
 *
 * Reference: https://www.dailycodingproblem.com/blog/how-to-find-arbitrage-opportunities-in-python/
 *
 */

import scala.math.log

object Problem32_Arbitrage {

  def solution(rates: Array[Array[Float]]): Boolean = {
    val transformed = rates.map(_.map(rate => -log(rate).toFloat))

    val source = 0
    val n = transformed.length
    val minDist = Array.fill[Float](n)(Float.MaxValue)
    minDist(source) = 0

    // relax edges |V-1| times
    for (_ <- 0 until n - 1) {
      for (v <- 0 until n) {
        for (w <- 0 until n) {
          if (minDist(w) > minDist(v) + transformed(v)(w)) {
            minDist(w) = minDist(v) + transformed(v)(w)
          }
        }
      }
    }

    // if we can still relax edges, we have a negative cycle
    for (v <- 0 until n) {
      for (w <- 0 until n) {
        if (minDist(w) > minDist(v) + transformed(v)(w)) return true
      }
    }
    false
  }
}
