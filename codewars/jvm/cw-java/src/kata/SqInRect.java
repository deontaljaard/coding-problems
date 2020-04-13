/*
Kata: Rectangle into Squares
*/

package kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SqInRect {
    public static List<Integer> sqInRect(int lng, int wdth) {
        if (lng == wdth) return null;

        return getBlocksForRect(lng, wdth);
    }

    private static List<Integer> getBlocksForRect(int length, int width) {
        List<Integer> blocks = new ArrayList<>();
        if (length < width)
            swap(length, width);

        int times, rem;
        while (width > 0) {
            times = length / width;
            rem = length % width;
            for (int i = 0; i < times; i++) {
                blocks.add(width);
            }
            length = width;
            width = rem;
        }
        return blocks;
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main(String... args) {
        assert(Objects.equals(sqInRect(5, 3), List.of(3, 2, 1, 1)));
    }
}
