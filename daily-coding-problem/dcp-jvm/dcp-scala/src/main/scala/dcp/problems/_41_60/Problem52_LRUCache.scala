package dcp.problems._41_60

import scala.collection.mutable

/**
 * This problem was asked by Google.
 *
 * Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain
 * the following methods:
 *
 * set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it
 * should also remove the least recently used item.
 * get(key): gets the value at key. If no such key exists, return null.
 *
 * Each operation should run in O(1) time.
 */

object Problem52_LRUCache {

  class Node[A](val key: Int, var data: A, var prev: Node[A] = null, var next: Node[A] = null)

  class LRUCache[A](val n: Int) {
    val cache: mutable.Map[Int, Node[A]] = new mutable.HashMap[Int, Node[A]]()
    var head: Node[A] = _
    var tail: Node[A] = _

    def set(key: Int, data: A): Unit = {
      if (cache.contains(key)) {
        val node = cache(key)
        node.data = data
        offerNode(node)
      } else {
        if (cache.size >= n) {
          cache.remove(head.key)
          removeNode(head)
        }
        val node = new Node(key, data)
        offerNode(node)
        cache.put(key, node)
      }
    }

    def get(key: Int): Option[A] = {
      if (!cache.contains(key)) None
      else {
        val node = cache(key)
        removeNode(node)
        offerNode(node)
        Some(node.data)
      }
    }

    private def removeNode(node: Node[A]): Unit = {
      if (node.prev != null) node.prev.next = node.next
      else head = node.next

      if (node.next != null) node.next.prev = node.prev
      else tail = node.prev
    }

    private def offerNode(node: Node[A]): Unit = {
      if (tail != null) tail.next = node
      node.prev = tail
      tail = node
      if (head == null) head = tail
    }
  }

}
