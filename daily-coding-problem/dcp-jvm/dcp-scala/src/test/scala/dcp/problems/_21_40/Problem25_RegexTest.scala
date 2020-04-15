package dcp.problems._21_40

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class Problem25_RegexTest extends AnyFlatSpecLike with Matchers {

  "Regex" should "should match special chars [.*]" in {
    Problem25_Regex.matches("ra.", "ray") should be(true)
    Problem25_Regex.matches("ra.", "raymond") should be(false)

    Problem25_Regex.matches(".*at", "chat") should be(true)
    Problem25_Regex.matches(".*at", "chats") should be(false)
  }

}
