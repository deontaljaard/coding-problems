package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class OddNumber {
    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (l % 2 != 0) result.add(i);
            else i++;
        }
        return result;
    }

    public static void main(String... args) {
        assert (oddNumbers(1, 7).equals(List.of(1, 3, 5, 7)));
        assert (oddNumbers(2, 10).equals(List.of(3, 5, 7, 9)));
    }
}
