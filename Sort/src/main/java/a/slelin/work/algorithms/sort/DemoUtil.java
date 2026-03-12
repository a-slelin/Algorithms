package a.slelin.work.algorithms.sort;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DemoUtil {

    public static int[] Array = new int[]{8, 3, 12, 16, 10, 4, 1, 9, 7, 14};

    public static void print(int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
