package codility;

import java.util.Arrays;

public class Burgers {

    // x = big + mini
    // y = big * 4 + mini * 2
    public static int[] solution(int cheese, int tomatoes) {
        int[] burgers = new int[]{-1, -1};
        int big = tomatoes / 2 - cheese;
        int mini = 2 * cheese - tomatoes / 2;
        if (big > 0 || mini > 0) {
            burgers[0] = mini;
            burgers[1] = big;
        }
        return burgers;
    }

    public static int[] solution2(int x, int y) {
        int[] burgers = new int[]{-1, -1};
        if (x % 2 == 0) {
            int bigBurgers = x / 4;
            int miniBurgers = (x - (bigBurgers * 4)) / 2;
            int cheeseSlicesRequired = bigBurgers + miniBurgers;
            if (x - (bigBurgers * 4 + miniBurgers * 2) == 0 && (y - cheeseSlicesRequired) == 0) {
                burgers[0] = miniBurgers;
                burgers[1] = bigBurgers;
            }
        }
        return burgers;
    }

    public static void main(String... args) {
//        System.out.println(Arrays.equals(solution(1, 1), new int[]{-1, -1}));
//        System.out.println(Arrays.equals(solution(1, 2), new int[]{1, 0}));
//        System.out.println(Arrays.equals(solution(7, 16), new int[]{6, 1}));
//        System.out.println(Arrays.equals(solution(15, 40), new int[]{10, 5}));
        int[] burgers = solution2(40, 15);
        System.out.println("Mini " + burgers[0] + " Big " + burgers[1]);
        System.out.println(Arrays.equals(burgers, new int[]{10, 5}));
    }
}
