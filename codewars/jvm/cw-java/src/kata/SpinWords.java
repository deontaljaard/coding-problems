/*
Kata: Stop gninnipS My sdroW!

Details:
Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
*/

package kata;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SpinWords {

    public static String spinWords(String sentence) {
        return Pattern.compile(" ")
                .splitAsStream(sentence)
                .map(word -> word.length() < 5 ? word : new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    public static void main(String... args) {
        assert(spinWords("Stop spinning this around!").equals("Stop gninnips this !dnuora"));
    }
}