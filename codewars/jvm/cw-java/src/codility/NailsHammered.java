package codility;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class NailsHammered {


    public static int solution(int[] A, int Y) {
        if (Y < 1) {
            return 0;
        }

        Map<Integer, Integer> grouping = groupNails(A);

        Map.Entry<Integer, Integer> highestNail = null;
        Map.Entry<Integer, Integer> candidateNail = null;
        int higherNails = 0;
        int lowerNails = 0;

        for (Map.Entry<Integer, Integer> entry : grouping.entrySet()) {
            if (highestNail == null) {
                highestNail = entry;
                higherNails += highestNail.getValue();
            } else if (candidateNail == null) {
                candidateNail = entry;
            } else if (candidateNail.getValue() < entry.getValue()) {
                higherNails += candidateNail.getValue();
                candidateNail = entry;
            } else {
                lowerNails += entry.getValue();
            }
        }
        lowerNails += candidateNail != null ? candidateNail.getValue() : 0;

        if (lowerNails > 0) {
            if (higherNails >= Y || highestNail.getValue() >= Y)
                return candidateNail.getValue() + Y;

            int result = candidateNail.getValue();
            Y -= highestNail.getValue();
            higherNails -= highestNail.getValue();
            result += highestNail.getValue();

            if (Y > higherNails) return result;
            else return result + Y;
        } else {
            return 0;
        }
    }

    private static Map<Integer, Integer> groupNails(int[] A) {
        Map<Integer, Integer> grouping = new TreeMap<>(Collections.reverseOrder());
        for (int value : A) {
            if (grouping.containsKey(value)) {
                grouping.put(value, grouping.get(value) + 1);
            } else {
                grouping.put(value, 1);
            }
        }
        return grouping;
    }

    public static void main(String... args) {
        System.out.println(solution(new int[]{1, 1, 3, 3, 3, 4, 5, 5, 5, 5}, 2)); // 5
        System.out.println(solution(new int[]{1, 1, 3, 3, 3, 4, 5, 5, 5, 5}, 4)); // 7
        System.out.println(solution(new int[]{1, 1, 3, 3, 3, 4, 5, 5, 5, 5}, 5)); // 8
        System.out.println(solution(new int[]{1, 1}, 5)); // 0
        System.out.println(solution(new int[]{1, 1, 2}, 5)); // 3
    }
}
