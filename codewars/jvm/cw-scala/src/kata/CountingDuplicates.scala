/*
Kata: Counting Duplicates

Details:
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
*/

package kata

object CountingDuplicates {
  def duplicateCount(str: String): Int = str.toLowerCase.toList.groupBy(identity).count(_._2.length > 1)

  def main(args: Array[String]): Unit = {
    assert(duplicateCount("aabb") == 2)
  }
}
