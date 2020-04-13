package codility;

import java.util.Set;
import java.util.TreeSet;

public class SmallestPositiveInteger {

    private static int solution(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int value : arr) {
            set.add(value);
        }

        for (int i = 1; i < arr.length + 1; i++) {
            if (!set.contains(i)) return i;
        }

        return arr.length + 1;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2})); // 5
        System.out.println(solution(new int[]{1, 2, 3})); // 4
        System.out.println(solution(new int[]{-3, -1})); // 1
        System.out.println(solution(new int[]{2})); // 1
    }
}
