package dcp.problems._41_60

import scala.util.Random

/**
 * This problem was asked by Facebook.
 *
 * Given a function that generates perfectly random numbers between 1 and k (inclusive), where k is an input, write a
 * function that shuffles a deck of cards represented as an array using only swaps.
 *
 * It should run in O(N) time.
 *
 * Hint: Make sure each one of the 52! permutations of the deck is equally likely.
 */

object Problem51_ShuffleCardDeck extends App {

  private val NUM_CARDS = 52
  private val CARDS = (0 until NUM_CARDS).toArray
  private val R = new Random()

  def randK(k: Int): Int = R.nextInt(k)

  def shuffle(cards: Array[Int]): Array[Int] = {

    for (currentPos <- cards.indices) {
      val newPos = currentPos + randK(NUM_CARDS - currentPos)
      val temp = cards(newPos)
      cards(newPos) = currentPos
      cards(currentPos) = temp
    }
    cards
  }

  (0 until 10).foreach { _ =>
    val shuffledDeck = shuffle(CARDS)
    assert(CARDS.forall(shuffledDeck.contains))
  }
}
