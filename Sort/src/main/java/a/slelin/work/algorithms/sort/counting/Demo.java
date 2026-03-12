package a.slelin.work.algorithms.sort.counting;

import static a.slelin.work.algorithms.sort.DemoUtil.print;

public class Demo {
    static void main() {
        int[] A = {-2, 5, 3, 2, 2, 3, 5, 3, 3, 6, 0, -1};
        boolean reverse = false;

        System.out.println("Before:");
        print(A);

        int[] B = CountingSort.sort(A, reverse);

        System.out.println("After:");
        print(B);
    }
}
