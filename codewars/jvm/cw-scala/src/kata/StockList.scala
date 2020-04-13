/*
Kata: Help the Bookseller!

Details:
A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more capitals letters. The 1st letter of a code is the capital letter of the book category. In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.
*/

package kata

import scala.util.Try

object StockList {
  type Code = String
  val takeStock: (Array[String], Code) => Long =
    (stockList, code) => stockList.foldLeft(0L) { case (acc, stock) =>
      if (stock.startsWith(code)) acc + Try(stock.split(" ")(1).toLong).getOrElse(0L)
      else acc
    }

  def stockSummary(lstOfArt: Array[String], lstOfCat: Array[String]): String = {
    if (lstOfArt.isEmpty || lstOfCat.isEmpty) ""
    else lstOfCat.map(code => s"($code : ${takeStock(lstOfArt, code)})").mkString(" - ")
  }

  def main(args: Array[String]): Unit = {
    val d = Array("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600")
    val e = Array("C", "D")
    assert(stockSummary(d, e) == "(C : 500) - (D : 600)")
  }
}
