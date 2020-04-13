package google

object PairsWithSum {

  // using complements
  def pairsWithSum(arr: Array[Int], sum: Int): Boolean = {
    var complements = Set.empty[Int]
    for (i <- arr.indices) {
      if (complements.contains(arr(i))) return true
      complements += sum - arr(i)
    }
    false
  }

  def main(args: Array[String]): Unit = {
    println(pairsWithSum(Array(1, 2, 4, 9), 8))
    println(pairsWithSum(Array(1, 2, 4, 4), 8))
    println(pairsWithSum(Array(1, 2, 4, 6, 3), 5))
    //    assert(!pairsWithSum(Array(1, 2, 4, 9), 8))
    //    assert(pairsWithSum(Array(1, 2, 4, 4), 8))
  }

}
