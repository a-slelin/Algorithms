package a.slelin.work.algorithms.sort.insertion;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InsertionSort {

    public static void sort(int[] A) {
        sort(A, false);
    }

    public static void sort(int[] A, boolean reverse) {
        for (int i = 1; i < A.length; ++i) {
            int j = i - 1, key = A[i];
            while (j >= 0 && (reverse ? A[j] < key : A[j] > key))
                A[j + 1] = A[j--];

            A[++j] = key;
        }
    }
}
