package dcp.problems._1_20

import scala.util.Random

object Problem14_EstimatePiMonteCarlo extends App {
  val rand = new Random()
  val iterations = 10000000
  var count = 0

  for (_ <- 0 to iterations) {
    val x = rand.nextFloat()
    val y = rand.nextFloat()
    if (inCircle(x, y)) count += 1
  }

  def inCircle(x: Double, y: Double): Boolean = x * x + y * y <= 1.0

  val piEst = (4 * count).toDouble / iterations
  println(s"PI Est:\t${String.format("%.3f", piEst)}")
  println(s"PI:\t\t${Math.PI}")
}
