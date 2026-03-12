package a.slelin.work.algorithms.sort.bubble;

import a.slelin.work.algorithms.sort.DemoUtil;

import static a.slelin.work.algorithms.sort.DemoUtil.print;

public class Demo {
    static void main() {
        int[] A = DemoUtil.Array;
        boolean reverse = false;

        System.out.println("Before:");
        print(A);

        BubbleSort.sort(A, reverse);

        System.out.println("After:");
        print(A);
    }
}
