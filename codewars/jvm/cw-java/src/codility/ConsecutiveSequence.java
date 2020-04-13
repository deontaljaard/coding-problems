package codility;

public class ConsecutiveSequence {

    public static int solution(int[] A) {
        int max = 1;
        int current = 1;

        for (int i = 1; i < A.length; i++) {
            if (greaterThanAndIncreasing(A[i], A[i - 1]) || lessThanAndDecreasing(A[i], A[i - 1])) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 1;
            }
        }
        return Math.max(max, current);
    }

    private static boolean greaterThanAndIncreasing(int a, int b) {
        return a > b && (a - 1) == b;
    }

    private static boolean lessThanAndDecreasing(int a, int b) {
        return a < b && a == (b - 1);
    }

    public static void main(String... args) {
        System.out.println(solution(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println(solution(new int[]{1, 2, 3, 10, 11, 15})); // 3
        System.out.println(solution(new int[]{5, 4, 2, 1})); // 2
        System.out.println(solution(new int[]{3, 5, 7, 10, 15})); // 1
        System.out.println(solution(new int[]{5, -3, -2, -1, 0, 1, 5, 6, 7})); // 5
        System.out.println(solution(new int[]{3, 4, 5, -2, -1, 0, 1, 6, 7})); // 4
        System.out.println(solution(new int[]{2, 3, 12, 11, 10, 9})); // 4
        System.out.println(solution(new int[]{4, 5, 6, -4, -3, -2, -1, 0, 2, 3})); // 5
        System.out.println(solution(new int[]{1, 3, 4, -7, -8, -9, -10, -11, 12, 11})); // 5
    }
}
