package codility.lessons.timecomplexity

import scala.math.{abs, ceil}

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
object FrogJmp {

  // too slow
  def solution2(x: Int, y: Int, d: Int): Int = {
    var jumps = 0
    var start = x
    while (start < y) {
      start += d
      jumps += 1
    }
    jumps
  }

  def solution(x: Int, y: Int, d: Int): Int = ceil(abs(x - y).toDouble / d.toDouble).toInt

  def main(args: Array[String]): Unit = {
    assert(solution(10, 85, 30) == 3)
    assert(solution2(10, 85, 30) == 3)
  }
}
