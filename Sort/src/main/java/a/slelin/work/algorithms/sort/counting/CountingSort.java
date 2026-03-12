package a.slelin.work.algorithms.sort.counting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CountingSort {

    public static int[] countingSort(int[] A, int min, int max) {
        int[] C = new int[max - min + 1], B = new int[A.length];
        for (int j : A) ++C[j - min];
        for (int i = 1; i <= max - min; ++i)
            C[i] += C[i - 1];

        for (int i = A.length - 1; i >= 0; --i)
            B[--C[A[i] - min]] = A[i];
        return B;
    }

    public static int[] sort(int[] A) {
        return sort(A, false);
    }

    public static int[] sort(int[] A, boolean reverse) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int j : A) {
            max = Math.max(max, j);
            min = Math.min(min, j);
        }

        int[] B = countingSort(A, min, max);
        if (reverse) {
            for (int i = 0; i < B.length / 2; ++i) {
                int tmp = B[i];
                B[i] = B[B.length - i - 1];
                B[B.length - i - 1] = tmp;
            }
        }

        return B;
    }
}
