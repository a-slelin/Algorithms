package a.slelin.work.algorithms.sort.bubble;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BubbleSort {

    public static void sort(int[] A) {
        sort(A, false);
    }

    public static void sort(int[] A, boolean reverse) {
        int n = A.length - 1;

        for (int i = 0; i <= n - 1; ++i) {
            boolean swapped = false;

            for (int j = n; j > i; --j) {
                if (reverse ? A[j] > A[j - 1] : A[j] < A[j - 1]) {
                    int tmp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = tmp;

                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
