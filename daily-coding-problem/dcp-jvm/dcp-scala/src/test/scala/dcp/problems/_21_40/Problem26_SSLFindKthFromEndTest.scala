package dcp.problems._21_40

import dcp.problems._21_40.Problem26_SSLFindKthFromEnd.Node
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem26_SSLFindKthFromEndTest extends AnyFlatSpecLike with Matchers {

  "SSLFindKthFromEnd" should "should find the kth node from the end of a SSL" in {
    val ssl = Node(1, Node(2, Node(3, Node(4))))
    Problem26_SSLFindKthFromEnd.findKthFromEnd(ssl, 2).data should be(2)
    Problem26_SSLFindKthFromEnd.findKthFromEnd(ssl, 0).data should be(4)
    Problem26_SSLFindKthFromEnd.findKthFromEnd(ssl, 3).data should be(1)
    Problem26_SSLFindKthFromEnd.findKthFromEnd(ssl, 1).data should be(3)

    Problem26_SSLFindKthFromEnd.findKthFromEnd2(ssl, 2).data should be(2)
    Problem26_SSLFindKthFromEnd.findKthFromEnd2(ssl, 0).data should be(4)
    Problem26_SSLFindKthFromEnd.findKthFromEnd2(ssl, 3).data should be(1)
    Problem26_SSLFindKthFromEnd.findKthFromEnd2(ssl, 1).data should be(3)
  }

}
