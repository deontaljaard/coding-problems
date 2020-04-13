package dcp.problems._1_20

import Problem20_SSLIntersection.Node
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem20_SSLIntersectionTest extends AnyFlatSpecLike with Matchers {

  "SSLIntersection" should "should return the intersecting node" in {
    val ssl1 = Node(3, Node(7, Node(8, Node(10))))
    val ssl2 = Node(0, Node(99, Node(1, Node(8, Node(10)))))
    val res = Problem20_SSLIntersection.intersection(ssl1, ssl2)
    res.value should be(8)
  }

}
