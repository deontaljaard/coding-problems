package hackerrank;

import java.util.List;

public class FindTheNumber {
    public static String findNumber(List<Integer> arr, int k) {
        for(Integer num : arr) {
            if(num == k) return "YES";
        }
        return "NO";
    }

    public static void main(String... args) {
        assert(findNumber(List.of(1, 3, 2, 6, 4), 8).equals("NO"));
        assert(findNumber(List.of(1, 3, 2, 6, 4), 4).equals("YES"));
    }
}
