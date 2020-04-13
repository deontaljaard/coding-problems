/*
Kata: Format a string of names like 'Bart, Lisa & Maggie'.

Details:
Given: an array containing hashes of names

Return: a string formatted as a list of names separated by commas except for the last two names, which should be separated by an ampersand.
*/

package kata

object NameFormat {

  def formatNames(names: Array[Map[String, String]]): String = {
    val last = if (names.length > 0) names(names.length - 1) else Map("name" -> "")
    val nameStr = names.view.take(names.length - 1).map(_.getOrElse("name", "")).mkString(", ")
    if (nameStr.nonEmpty) s"${nameStr} & ${last.getOrElse("name", "")}" else s"${last.getOrElse("name", "")}"
  }

  def main(args: Array[String]): Unit = {
    assert(formatNames(Array(Map("name" -> "Bart"), Map("name" -> "Lisa"), Map("name" -> "Maggie"), Map("name" -> "Homer"), Map("name" -> "Marge"))) == "Bart, Lisa, Maggie, Homer & Marge")
    assert(formatNames(Array(Map("name" -> "Bart"), Map("name" -> "Lisa"))) == "Bart & Lisa")
    assert(formatNames(Array(Map("name" -> "Bart"))) == "Bart")
  }
}
