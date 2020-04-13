/*
Kata: Counting Duplicates

Details:
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
*/

package kata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (seen.contains(c)) {
                duplicates.add(c);
            } else {
                seen.add(c);
            }
        }
        return duplicates.size();
    }

    public static int duplicateCount2(String text) {
        Map<Character, Integer> tracker = new HashMap<>();
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            tracker.put(c, tracker.getOrDefault(c, 0) + 1);

            if (tracker.get(c) == 2) {
                count++;
            }
        }
        return count;
    }

    public static void main(String... args) {
        assert(duplicateCount2("aabb") == 2);
        assert(duplicateCount2("aabbcdeef") == 3);
    }
}
