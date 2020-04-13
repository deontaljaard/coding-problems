package codility.lessons.iterations

/**
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */

object BinaryGap {
  def solution(n: Int): Int = {
    @scala.annotation.tailrec
    def findGap(binary: String, index: Int = 0, currGap: Int = 0, gaps: Set[Int] = Set(0)): Int = {
      if(binary.length - 1 == index) gaps.max
      else {
        if(binary(index).toString == "0") findGap(binary, index + 1, currGap + 1, gaps)
        else findGap(binary, index + 1, 0, gaps + currGap)
      }
    }
    findGap(n.toBinaryString)
  }

  def solution2(n: Int): Int = {
    val binary = n.toBinaryString
    var currGap = 0
    var gaps = Set(0)
    for(i <- Range(0, binary.length)) {
      if(binary(i).toString == "0") currGap += 1
      else {
        gaps += currGap
        currGap = 0
      }
    }
    gaps.max
  }

  def main(args: Array[String]): Unit = {
    assert(solution2(1041) == 5)
    assert(solution2(32) == 0)
  }
}
