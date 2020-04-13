package lessons.dynamicprogramming

object ChangeMaker {
  val INF = 1000

  // find the minimum number of coins needed
  def solution2(denominations: Array[Int], amount: Int): Int = {
    val count = denominations.length - 1
    val M = new Array[Int](amount + 1)
    M(0) = 0

    val S = new Array[Int](amount + 1)
    S(0) = 0

    var j = 1
    while (j <= amount) {
      var minimum = INF
      var coin = 0
      var i = 1
      while (i <= count) {
        if (j >= denominations(i)) {
          if ((1 + M(j - denominations(i))) < minimum) {
            minimum = 1 + M(j - denominations(i))
            coin = i
          }
        }

        i += 1
      }
      M(j) = minimum
      S(j) = coin

      j += 1
    }

    var l = amount
    while (l > 0) {
      System.out.println(denominations(S(l)))
      l = l - denominations(S(l))
    }

    M(amount)
  }

  def solution(d: Array[Int], k: Int): Int = {
    val M = Array(0) ++ Array.fill(k)(d.max)
    for (i <- Range(1, d.length + 1)) {
      val denom = d(i - 1)
      for (j <- Range(denom, k + 1)) {
        M(j) = math.min(M(j - denom) + 1, M(j))
      }
    }
    M(k)
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(1, 3, 4), 6))
    assert(solution(Array(1, 3, 4), 6) == 2)
  }
}
