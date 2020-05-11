package dcp.problems._41_60

import dcp.problems._41_60.Problem52_LRUCache._
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem52_LRUCacheTest extends AnyFlatSpecLike with Matchers {

  "LRUCache" should "should set a key to a value, and get it" in {
    val cache = new LRUCache[Char](2)
    cache.set(1, 'a')
    cache.get(1) should be(Some('a'))

    // override
    cache.set(1, 'a')
    cache.set(1, 'b')
    cache.get(1) should be(Some('b'))

    // remove LRU key
    cache.set(1, 'a')
    cache.set(2, 'b')
    cache.set(3, 'c')
    cache.get(1) should be(None)
  }

}
