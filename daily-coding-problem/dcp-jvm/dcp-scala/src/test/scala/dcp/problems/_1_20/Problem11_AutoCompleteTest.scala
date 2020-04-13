package dcp.problems._1_20

import Problem11_AutoComplete.Trie
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem11_AutoCompleteTest extends AnyFlatSpecLike with Matchers {

  "AutoComplete" should "return strings that matches a prefix" in {
    val trie = new Trie()
    trie.append("dog")
    trie.append("deer")
    trie.append("deal")
    trie.findByPrefix("de") should be(Seq("deal", "deer"))
  }

}
