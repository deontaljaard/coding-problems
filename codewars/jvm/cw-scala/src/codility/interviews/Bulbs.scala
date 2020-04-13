package codility.interviews

object Bulbs {

  def solution(a: Array[Int]): Int = {
    var allBulbsShining = 0
    val circuit = scala.collection.mutable.Map[Int, Boolean]()
    // initialise circuit
    for (moment <- a.indices) {
      val bulb = a(moment)
      circuit(bulb) = false
    }

    // play moments
    for (moment <- a.indices) {
      val bulb = a(moment)
      circuit(bulb) = true
      val onBulbs = circuit.keys.filter(circuit(_)).toList.sorted
      val series = Array.fill(onBulbs.size)(false)
      for (i <- onBulbs.indices) {
        // check order
        if (i == onBulbs(i) - 1) series(i) = true
      }
      if (series.forall(_ == true)) allBulbsShining += 1
    }
    allBulbsShining
  }

  def main(args: Array[String]): Unit = {
    assert(solution(Array(2, 1, 3, 5, 4)) == 3)
    assert(solution(Array(2, 3, 4, 1, 5)) == 2)
    assert(solution(Array(1, 3, 4, 2, 5)) == 3)
  }
}
