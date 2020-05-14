package dcp.problems._41_60

import java.nio.charset.StandardCharsets

import scala.collection.mutable

/**
 * This problem was asked by Microsoft.
 *
 * Implement a URL shortener with the following methods:
 *
 * shorten(url), which shortens the url into a six-character alphanumeric string, such as zLg6wl.
 * restore(short), which expands the shortened string into the original url. If no such shortened string exists, return null.
 *
 * Hint: What if we enter the same URL twice?
 */

import java.net.URLEncoder
import java.security.MessageDigest

object Problem55_UrlShortener extends App {

  class UrlShortener {
    private val PREFIX = "https://urlsho.rt/"
    private val CHARSET = StandardCharsets.UTF_8
    private val URL_LENGTH = 6
    val urls: mutable.Map[String, String] = mutable.Map[String, String]()

    def shorten(url: String): String = {
      val digestInstance = MessageDigest.getInstance("SHA-256")
      val encodedUrl = URLEncoder.encode(url, CHARSET)
      val bytes = encodedUrl.getBytes(CHARSET)
      val hash = digestInstance.digest(bytes)
      val shortHash = hash.map("%02x".format(_)).mkString.take(URL_LENGTH)
      urls.addOne(shortHash, url)
      String.format("%s%s", PREFIX, shortHash)
    }

    def restore(short: String): Option[String] = {
      val shortHash = short.replace(PREFIX, "")
      urls.get(shortHash)
    }
  }

}
