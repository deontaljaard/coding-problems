/*
Kata: Format a string of names like 'Bart, Lisa & Maggie'.

Details:
Given: an array containing hashes of names

Return: a string formatted as a list of names separated by commas except for the last two names, which should be separated by an ampersand.
*/

package kata;

import java.util.List;
import java.util.Map;

public class NameFormat {

    public static String formatNames(List<Map<String, String>> names) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i == 0) {
                sb.append(names.get(i).get("name"));
            } else if (i < names.size() - 1) {
                sb.append(", ").append(names.get(i).get("name"));
            } else if (i == names.size() - 1) {
                sb.append(" & ").append(names.get(i).get("name"));
            }
        }
        return sb.toString();
    }

    public static void main(String... args) {
        assert (formatNames(List.of(Map.of("name", "Bart"), Map.of("name", "Lisa"), Map.of("name", "Maggie"), Map.of("name", "Homer"),
                Map.of("name", "Marge"))).equals("Bart, Lisa, Maggie, Homer & Marge"));
        assert (formatNames(List.of(Map.of("name", "Bart"), Map.of("name", "Lisa"))).equals("Bart & Lisa"));
        assert (formatNames(List.of(Map.of("name", "Bart"))).equals("Bart"));
    }
}