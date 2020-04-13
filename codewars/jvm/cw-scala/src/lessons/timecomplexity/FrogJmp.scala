package lessons.timecomplexity

import scala.math.{abs, ceil}

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
  println(solution(10, 85, 30))
  }
}
