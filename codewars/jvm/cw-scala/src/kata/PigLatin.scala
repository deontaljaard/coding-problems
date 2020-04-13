/*
Kata: Simple Pig Latin

Details:
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
*/

package kata

object PigLatin {

  def pigIt(str: String): String = str.split(" ").map {
    case word if word.length > 1 => word.substring(1) + word.substring(0, 1) + "ay"
    case word => word
  }.mkString(" ")


  def main(args: Array[String]): Unit = {
    assert(pigIt("How are you doing?") == "owHay reaay ouyay oing?day")
    assert(pigIt("Pig latin is cool") == "igPay atinlay siay oolcay")
  }
}
