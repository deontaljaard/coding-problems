package dcp.problems._1_20

/**
 * This problem was asked by Facebook.
 *
 * A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing
 * cost while ensuring that no two neighboring houses are of the same color.
 *
 * Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
 * return the minimum cost which achieves this goal.
 */

object Problem19_MinCost {

  def solution(costs: Array[Array[Int]]): Int = {
    var cost = Array.fill(costs.length)(0)
    for (houseRow <- costs) {
      val tempCost = Array.fill(costs.length)(0)
      for (houseNum <- houseRow.indices) {
        val costBeforeHouse = cost.slice(0, houseNum)
        val costAfterHouse = cost.slice(houseNum + 1, cost.length)
        tempCost(houseNum) = houseRow(houseNum) + (costBeforeHouse ++ costAfterHouse).min
      }
      cost = tempCost
    }
    cost.min
  }

}
