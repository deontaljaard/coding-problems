package codility.interviews

object Equi {


  def solution(a: Array[Int]): Int = {
    for (i <- a.indices) {
      val arr1 = a.slice(0, i)
      val sum1 = arr1.sum
      val arr2 = a.slice(i + 1, a.length)
      val sum2 = arr2.sum
      if (sum1 == sum2) return i
    }
    -1
  }

  // prefix sums
  def solution2(a: Array[Int]): Int = {
    var sum = a.sum
    var leftSum = 0
    for (i <- a.indices) {
      sum -= a(i)
      if (leftSum == sum) return i
      leftSum += a(i)
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    //    assert(Array(1, 3, 7).contains(solution3(Array(-1, 3, -4, 5, 1, -6, 2, 1))))
    assert(Array(3, 6).contains(solution2(Array(-7, 1, 5, 2, -4, 3, 0))))
  }
}
