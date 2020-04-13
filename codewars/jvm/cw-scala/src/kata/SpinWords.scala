/*
Kata: Stop gninnipS My sdroW!

Details:
Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
*/

package kata

object SpinWords {
  def spinWords(sentence: String): String = {
    sentence.split(" ").map(word => if(word.length >= 5) word.reverse else word).mkString(" ")
  }

  def main(args: Array[String]): Unit = {
    assert(spinWords("Stop spinning this around!") == "Stop gninnips this !dnuora")
  }
}
