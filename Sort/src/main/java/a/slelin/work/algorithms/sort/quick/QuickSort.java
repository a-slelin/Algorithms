package a.slelin.work.algorithms.sort.quick;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class QuickSort {

    public static int partition(int[] A, int p, int r, boolean reverse) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; ++j)
            if (reverse ? A[j] >= x : A[j] <= x) {
                int tmp = A[++i];
                A[i] = A[j];
                A[j] = tmp;
            }

        int tmp = A[++i];
        A[i] = A[r];
        A[r] = tmp;

        return i;
    }

    public static int randomizedSort(int[] A, int p, int r, boolean reverse) {
        int i = new Random().nextInt(p, r + 1);

        int tmp = A[r];
        A[r] = A[i];
        A[i] = tmp;

        return partition(A, p, r, reverse);
    }

    public static void quickSort(int[] A, int p, int r, boolean reverse, boolean randomized) {
        if (p < r) {
            int q;
            if (randomized) q = randomizedSort(A, p, r, reverse);
            else q = partition(A, p, r, reverse);
            quickSort(A, p, q - 1, reverse, randomized);
            quickSort(A, q + 1, r, reverse, randomized);
        }
    }

    public static void sort(int[] A) {
        sort(A, false);
    }

    public static void sort(int[] A, boolean reverse) {
        sort(A, reverse, false);
    }

    public static void sort(int[] A, boolean reverse, boolean randomized) {
        quickSort(A, 0, A.length - 1, reverse, randomized);
    }
}
