package dcp.problems._41_60

import dcp.problems._41_60.Problem55_UrlShortener.UrlShortener
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem55_UrlShortenerTest extends AnyFlatSpecLike with Matchers {

  val URL = "https://www.google.co.za"

  "UrlShortener" should "shorten and restore a URL" in {
    val shortener = new UrlShortener()
    val short1 = shortener.shorten(URL)
    shortener.restore(short1).get should be(URL)
    val short2 = shortener.shorten(URL)
    shortener.restore(short2).get should be(URL)
  }

}
