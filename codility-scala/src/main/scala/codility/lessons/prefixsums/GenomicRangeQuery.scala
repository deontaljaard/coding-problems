package codility.lessons.prefixsums

import scala.collection.mutable

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 */

object GenomicRangeQuery {

  // O(N+M) - 100% - http://csharplabtests.blogspot.com/2015/06/codility-lesson-3-genomicrangequery.html
  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val count: Array[Array[Int]] = Array.ofDim[Int](s.length + 1, 4)
    for (i <- s.indices) {
      for (j <- 0 until 4) {
        count(i + 1)(j) = count(i)(j)
      }

      s(i) match {
        case 'A' => count(i + 1)(0) = count(i + 1)(0) + 1
        case 'C' => count(i + 1)(1) = count(i + 1)(1) + 1
        case 'G' => count(i + 1)(2) = count(i + 1)(2) + 1
        case 'T' => count(i + 1)(3) = count(i + 1)(3) + 1
      }
    }

    val results = new Array[Int](p.length)
    for (i <- p.indices) {
      val pi = p(i)
      val qi = q(i)
      var done = false
      var idx = 0
      while (!done) {
        if (count(qi + 1)(idx) - count(pi + 0)(idx) > 0) {
          results(i) = idx + 1
          done = true
        }
        idx += 1
      }
    }
    results
  }

  // inefficient - O(N*M) - 62%
  def solution2(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val dnaImpactFactor = s.toCharArray.map { case 'A' => 1; case 'C' => 2; case 'G' => 3; case 'T' => 4 }
    val result = mutable.ArrayBuffer[Int]()
    for (i <- p.indices) {
      result += dnaImpactFactor.slice((p(i)), q(i) + 1).min
    }
    result.toArray
  }

  // inefficient - O(N*M) - 75%
  def solution3(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val dnaImpactFactor = List('A' -> 1, 'C' -> 2, 'G' -> 3, 'T' -> 4)
    val result = new Array[Int](p.length)
    for (i <- p.indices) {
      val slice = s.slice(p(i), q(i) + 1)
      var done = false
      var idx = 0
      while (!done) {
        val (char, factor) = dnaImpactFactor(idx)
        if (slice.contains(char)) {
          result(i) = factor
          done = true
        }
        idx += 1
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    //    assert(solution("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6)) sameElements Array(2, 4, 1))
    //    assert(solution2("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6)) sameElements Array(2, 4, 1))
    assert(solution3("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6)) sameElements Array(2, 4, 1))
  }
}
