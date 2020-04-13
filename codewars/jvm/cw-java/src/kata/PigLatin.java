/*
Kata: Simple Pig Latin

Details:
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
*/

package kata;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatin {
    private static final Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

    public static String pigIt(String str) {
        String[] words = str.split(" ");
        return Arrays.stream(words).map(word -> {
            Matcher matcher = pattern.matcher(word);
            if (!matcher.matches()) {
                return word;
            } else {
                return word.substring(1) + word.substring(0, 1) + "ay";
            }
        }).collect(Collectors.joining(" "));
    }

    public static void main(String... args) {
        assert(pigIt("How are you doing?").equals("owHay reaay ouyay oing?day"));
    }
}