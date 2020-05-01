package dcp.problems._41_60

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable

class Problem41_FlightItineraryTest extends AnyFlatSpecLike with Matchers {

  "FlightItinerary" should "compute a person's itinerary" in {
    Problem41_FlightItinerary.getItinerary(Array(("SFO", "HKO"), ("YYZ", "SFO"), ("YUL", "YYZ"), ("HKO", "ORD")), mutable.ArrayBuffer("YUL")) should be(List("YUL", "YYZ", "SFO", "HKO", "ORD"))
    Problem41_FlightItinerary.getItinerary(Array(("SFO", "COM"), ("COM", "YYZ"), ("YUL", "YYZ"), ("HKO", "ORD")), mutable.ArrayBuffer("YUL")) should be(Nil)
    Problem41_FlightItinerary.getItinerary(Array(("A", "B"), ("A", "C"), ("B", "C"), ("C", "A")), mutable.ArrayBuffer("A")) should be(List("A", "B", "C", "A", "C"))
  }

}
