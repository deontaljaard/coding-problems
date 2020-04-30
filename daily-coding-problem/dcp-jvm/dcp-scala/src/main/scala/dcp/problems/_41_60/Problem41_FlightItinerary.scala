package dcp.problems._41_60

import scala.collection.mutable

/**
 * This problem was asked by Facebook.
 *
 * Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting
 * airport, compute the person's itinerary. If no such itinerary exists, return null. If there are multiple possible
 * itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.
 *
 * For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting
 * airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
 *
 * Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.
 *
 * Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should
 * return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. However,
 * the first one is lexicographically smaller.
 */

object Problem41_FlightItinerary {

  def getItinerary(flights: Array[(String, String)], itinerary: mutable.ArrayBuffer[String]): List[String] = {
    if (flights.isEmpty) itinerary.toList
    else {
      val lastStop = itinerary(itinerary.length - 1)
      for (((from, to), i) <- flights.zipWithIndex) {
        if (from == lastStop)
          return getItinerary(flights.slice(0, i) ++ flights.slice(i + 1, flights.length), itinerary :+ to)
      }
      Nil
    }
  }
}
