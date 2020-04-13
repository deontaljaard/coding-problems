package dcp.problems._1_20

import scala.util.Random

/**
 * This problem was asked by Facebook.
 *
 * Given a stream of elements too large to store in memory, pick a random element from the stream with
 * uniform probability.
 */

object Problem15_RandElement extends App {

  def solution(stream: LazyList[Int]): Int = {
    var randVal = 0
    val rand = new Random()
    for (i <- stream.indices) {
      if (i == 0) randVal = i
      else if (rand.between(1, i + 1) == 1) randVal = stream(i)
    }
    randVal
  }

  val stream: LazyList[Int] = LazyList.from(1 to 1000000)
  println(solution(stream))
  println(solution(stream))
  println(solution(stream))
}
