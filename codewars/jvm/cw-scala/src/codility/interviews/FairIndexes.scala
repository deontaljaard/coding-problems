package codility.interviews

object FairIndexes {

  val sliceArr: (Int, Array[Int]) => (Array[Int], Array[Int]) = (index, array) =>
    (array.slice(0, index), array.slice(index, array.length))

  def solution(a: Array[Int], b: Array[Int]): Int = {
    def equal(index: Int, arr1: Array[Int], arr2: Array[Int]): Int = {
      val (a11, a12) = sliceArr(index, arr1)
      val (b11, b12) = sliceArr(index, arr2)
      if (a11.nonEmpty && a12.nonEmpty
        && b11.nonEmpty && b12.nonEmpty
        && Set(a11.sum, a12.sum, b11.sum, b12.sum).size == 1) 1 else 0
    }
    // TODO: range check
    a.indices.map(equal(_, a, b)).sum
  }


  def main(args: Array[String]): Unit = {
    assert(solution(Array(4, -1, 0, 3), Array(-2, 5, 0, 3)) == 2)
    assert(solution(Array(2, -2, -3, 3), Array(0, 0, 4, -4)) == 1)
    assert(solution(Array(4, -1, 0, 3), Array(-2, 6, 0, 4)) == 0)
    assert(solution(Array(3, 2, 6), Array(4, 1, 6)) == 0)
    assert(solution(Array(1, 4, 2, -2, 5), Array(7, -2, -2, 2, 5)) == 2)
  }
}
