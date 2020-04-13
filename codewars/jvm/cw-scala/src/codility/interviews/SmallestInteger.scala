package codility.interviews

object SmallestInteger {

  val vectorize: Int => IndexedSeq[Int] = _.toString.map(_.asDigit)

  def solution(n: Int): Int = {
    val target = vectorize(n).sum
    @scala.annotation.tailrec
    def calc(smallest: Int): Int = {
      if(vectorize(smallest).sum == target) smallest
      else calc(smallest + 1)
    }
    calc(n + 1)
  }

  def main(args: Array[String]): Unit = {
    println(solution(50000))
//    assert(solution(28) == 37)
//    assert(solution(734) == 743)
//    assert(solution(1990) == 2089)
//    assert(solution(1000) == 10000)
  }
}
