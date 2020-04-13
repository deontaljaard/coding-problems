package codility.interviews

object BinaryDivision {

  def solution(s: String): Int = {
    var value = Integer.parseInt(s, 2)
    var steps = 0
    while (value > 0) {
      if (value % 2 == 0) {
        value = value / 2
        steps += 1
      } else {
        value -= 1
        steps += 1
      }
    }
    steps
  }

  def main(args: Array[String]): Unit = {
    println(solution("011100") == 7)
  }
}
