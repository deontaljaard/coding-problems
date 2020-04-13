/*
Kata: Rectangle into Squares
*/

package kata

object SqInRect {

  def sqInRect(min: Int, max: Int): Array[Int] = {
    if(min == max) return Array()

    @scala.annotation.tailrec
    def calc(w: Int, l: Int, squares: Array[Int] = Array.empty[Int]): Array[Int] = {
      if (w <= 0 || l <= 0) squares
      else {
        val count: Int = w / l
        val rem = w % l
        calc(l, rem, squares ++ Array.fill(count)(l))
      }
    }
    calc(min, max)
  }

  def main(args: Array[String]): Unit = {
    assert(sqInRect(5, 3) sameElements Array(3, 2, 1, 1))
  }
}
