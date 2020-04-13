package codility;

public class Fishes {


    public static int solution(String S) {
        int survivors = 1;
        char predator = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            char currentFish = S.charAt(i);
            if (predator == currentFish) continue;
            if (!canEat(predator, currentFish)) { survivors++; }
            predator = currentFish;
        }
        return survivors;
    }

    private static boolean canEat(char predator, char prey) {
        switch (predator) {
            case 'A':
                return prey == 'B' || prey == 'C';
            case 'B':
                return prey == 'C' || prey == 'D';
            case 'C':
                return prey == 'D';
            default:
                return false;
        }
    }

    public static void main(String... args) {
        assert solution("ABAD") == 3; // 3
        assert solution("ACCD") == 1; // 1
        assert solution("BCD") == 1; // 1
    }
}
