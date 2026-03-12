package a.slelin.work.algorithms.sort.merge;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MergeSort {

    public static void merge(int[] A, int p, int q, int r, boolean reverse) {
        int len1 = q - p + 1, len2 = r - q;
        int[] L = new int[len1 + 1], R = new int[len2 + 1];
        if (len1 >= 0) System.arraycopy(A, p, L, 0, len1);
        for (int i = 0; i < len2; ++i)
            R[i] = A[i + q + 1];
        L[len1] = R[len2] = reverse ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; ++k)
            if (reverse ? L[i] > R[j] : L[i] < R[j]) A[k] = L[i++];
            else A[k] = R[j++];
    }

    public static void mergeSort(int[] A, int p, int r, boolean reverse) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q, reverse);
            mergeSort(A, q + 1, r, reverse);
            merge(A, p, q, r, reverse);
        }
    }

    public static void sort(int[] A) {
        sort(A, false);
    }

    public static void sort(int[] A, boolean reverse) {
        mergeSort(A, 0, A.length - 1, reverse);
    }
}
