package dcp.problems._1_20

/**
 * This problem was asked by Jane Street.
 *
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
 * For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 *
 * Implement car and cdr
 */

object Problem5_FunctionalPair {

  type FunctionalPair = ((Int, Int) => Int) => Int

  def cons(a: Int, b: Int): FunctionalPair =
    (f: (Int, Int) => Int) => f(a, b)

  def car(pair: FunctionalPair): Int = {
    val f = (a: Int, _: Int) => a
    pair(f)
  }

  def cdr(pair: FunctionalPair): Int = {
    val f = (_: Int, b: Int) => b
    pair(f)
  }

}
