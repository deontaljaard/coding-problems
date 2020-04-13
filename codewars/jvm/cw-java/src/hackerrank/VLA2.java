package hackerrank;

import java.util.*;

public class VLA2 implements Comparator<VLA2> {
    int dishSize;

    public static void main(String[] args) {
        VLA2[] va = {new VLA2(40), new VLA2(200), new VLA2(60)};
        Arrays.sort(va, va[0]);
        for(VLA2 a : va) {
            System.out.println(a.dishSize);
        }
        System.out.println();
        int index = Arrays.binarySearch(va, new VLA2(40), va[0]);
        System.out.print(index + " ");
        index = Arrays.binarySearch(va, new VLA2(80), va[0]);
        System.out.print(index);
    }

    public int compare(VLA2 a, VLA2 b) {
        return b.dishSize - a.dishSize;
    }

    VLA2(int d) { dishSize = d; }
}