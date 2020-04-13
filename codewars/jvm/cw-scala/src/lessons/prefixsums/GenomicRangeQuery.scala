package lessons.prefixsums

import scala.collection.mutable

object GenomicRangeQuery {

  case class Genome(dna: String) {
    val seq: Map[Char, Array[Int]] = Map('A' -> Array(), 'C' -> Array(), 'G' -> Array(), 'T' -> Array())
  }

  // inefficient - O(N*M)
  def solution(S: String, P: Array[Int], Q: Array[Int]): Array[Int] = {
    val A = new Array[Int](S.length)
    val C = new Array[Int](S.length)
    val G = new Array[Int](S.length)
    val T = new Array[Int](S.length)
    // note: we use "S.length()+1"
    // which will let A[0]=0, C[0]=0, G[0]=0, T[0]=0
    // becasue we will compute number of 'a' by "A[Q+1] - A[P]"
    // we actually shift to right by one, and assume the biginning is a dummy '0'

    // counting ( note: A[0]=0, C[0]=0, G[0]=0, T[0]=0 )
    var i = 0
    while (i < S.length) {
      if (S(i) == 'A') {
        A(i) = A(i)
        C(i) = C(i)
        G(i) = G(i)
        T(i) = T(i)
      }
      else if (S(i) == 'C') {
        A(i) = A(i)
        C(i) = C(i)
        G(i) = G(i)
        T(i) = T(i)
      }
      else if (S(i) == 'G') {
        A(i) = A(i)
        C(i) = C(i)
        G(i) = G(i)
        T(i) = T(i)
      }
      else if (S(i) == 'T') {
        A(i) = A(i)
        C(i) = C(i)
        G(i) = G(i)
        T(i) = T(i)
      }

      i += 1
    }

    val result = for (i <- P.indices) yield {
      val a = A(Q(i) + 1) - A(P(i)) // num of 'a' between P and Q
      val c = C(Q(i) + 1) - C(P(i)) // num of 'c' between P and Q
      val g = G(Q(i) + 1) - G(P(i)) // num of 'g' between P and Q

      if (a > 0) 1
      else if (c > 0) 2
      else if (g > 0) 3
      else 4
    }
    result.toArray
  }

  def solution3(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
//    val dnaImpactFactor = mutable.Map(
//      A -> mutable.ArrayBuffer[Int](),
//      C -> mutable.ArrayBuffer[Int](),
//      G -> mutable.ArrayBuffer[Int](),
//      T -> mutable.ArrayBuffer[Int]()
//    )

    //    for (i <- Range(0, s.length)) {
    //      s(i) match {
    //        case A.letter =>
    //          dnaImpactFactor.update(A,)
    //        case C.letter =>
    //        case G.letter =>
    //        case T.letter =>
    //      }
    //    }


    val result = mutable.ArrayBuffer[Int]()
    //    for (i <- p.indices) {
    //      result += dnaImpactFactor.slice((p(i)), q(i)).min
    //    }
    result.toArray
  }


  // inefficient - O(N*M)
  def solution2(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val dnaImpactFactor = s.toCharArray.map { case 'A' => 1; case 'C' => 2; case 'G' => 3; case 'T' => 4 }
    val result = mutable.ArrayBuffer[Int]()
    for (i <- p.indices) {
      result += dnaImpactFactor.slice((p(i)), q(i)).min
    }
    result.toArray
  }

  def main(args: Array[String]): Unit = {
    assert(solution("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6)) sameElements Array(2, 4, 1))
  }
}
