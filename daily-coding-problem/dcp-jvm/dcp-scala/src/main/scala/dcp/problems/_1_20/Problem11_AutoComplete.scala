package dcp.problems._1_20

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
 * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
 * return all strings in the set that have s as a prefix.
 *
 * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 *
 * Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
 */

object Problem11_AutoComplete {

  class Trie() {
    val child: Array[Trie] = new Array[Trie](26)
    var word: Option[String] = None

    def append(word: String): Unit = {
      @scala.annotation.tailrec
      def add(curIdx: Int, trie: Trie): Unit = {
        if (curIdx == word.length) trie.word = Some(word)
        else {
          val char = word.charAt(curIdx) - 'a' // convert to int 0-25
          if (trie.child(char) == null) trie.child(char) = new Trie()
          add(curIdx + 1, trie.child(char))
        }
      }

      add(0, this)
    }

    def findByPrefix(prefix: String): Seq[String] = {
      val prefixNode = findPrefixNode(prefix, this)
      if (prefixNode != null) collectWordsAt(prefixNode).toSeq else Seq.empty[String]
    }

    @tailrec
    final def findPrefixNode(prefix: String, currTrie: Trie): Trie = {
      if (prefix.isEmpty) currTrie
      else {
        val idx = prefix.charAt(0) - 'a'
        if (currTrie == null || currTrie.child(idx) == null) null
        else findPrefixNode(prefix.substring(1), currTrie.child(idx))
      }
    }

    // dfs
    def collectWordsAt(trie: Trie, acc: ListBuffer[String] = ListBuffer[String]()): ListBuffer[String] = {
      if (trie.word.isDefined) acc.append(trie.word.get)
      else {
        for (i <- trie.child.indices) {
          if (trie.child(i) != null) collectWordsAt(trie.child(i), acc)
        }
        acc
      }
    }

  }

}


