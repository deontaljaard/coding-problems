package codility;

import java.util.ArrayList;
import java.util.List;

public class WordsOfN {
    public static String[] solution(int N, int K) {
        if (N == 0) {
            return new String[]{""};
        }
        ArrayList<String> result = new ArrayList<String>();
        for (String p : solution(N - 1, K - 1)) {
            for (char l : new char[]{'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        int prefSize = Math.min(result.size(), K);
        List<String> strings = result.subList(0, prefSize);
        String[] strings1 = strings.toArray(new String[prefSize]);
        return strings1;
    }

    public static void main(String... args) {
//        String[] solution1 = solution(2, 4); // "ab", "ac", "ba", "bc" // 4
//        System.out.println(solution1);
        String[] solution = solution(10, 100); // "ab", "ac", "ba", "bc" // 4
        System.out.println(solution);
//        String[] solution2 = solution(3, 20); // "aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc" // 12
//        System.out.println(solution2);
//        String[] solution3 = solution(5, 6); // "ababa", "ababc", "abaca", "abacb", "abcab", "abcac" // 6
//        System.out.println(solution3);
    }
}
