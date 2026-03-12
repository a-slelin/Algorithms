package a.slelin.work.algorithms.sort.selection;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SelectionSort {

    public static void sort(int[] A) {
        sort(A, false);
    }

    public static void sort(int[] A, boolean reverse) {
        for (int i = 0; i < A.length - 1; ++i) {
            int index = i;
            for (int j = i; j < A.length; ++j)
                if (reverse ? A[index] < A[j] : A[index] > A[j]) index = j;

            int tmp = A[i];
            A[i] = A[index];
            A[index] = tmp;
        }
    }
}
