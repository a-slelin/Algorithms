package a.slelin.work.algorithms.ordinal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OrdinalStatics {

    public static int getMin(int[] A) {
        return getMinMax(A)[0];
    }

    public static int getMax(int[] A) {
        return getMinMax(A)[1];
    }

    public static int[] getMinMax(int[] A) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int j : A) {
            max = Math.max(max, j);
            min = Math.min(min, j);
        }

        return new int[]{min, max};
    }

    public static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (A[j] <= x) {
                int tmp = A[++i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }

        int tmp = A[++i];
        A[i] = A[r];
        A[r] = tmp;

        return i;
    }

    public static int randomizedPartition(int[] A, int p, int r) {
        int i = new Random().nextInt(p, r + 1);

        int tmp = A[i];
        A[i] = A[r];
        A[r] = tmp;

        return partition(A, p, r);
    }

    public static int randomizedSelect(int[] A, int p, int r, int i) {
        if (p == r)
            return A[p];

        int q = randomizedPartition(A, p, r);
        int k = q - p + 1;
        if (i == k)
            return A[q];
        else if (i < k)
            return randomizedSelect(A, p, q - 1, i);
        else
            return randomizedSelect(A, q + 1, r, i - k);
    }

    public static int getStatics(int[] A, int i) {
        if (i < 0 || i > A.length)
            throw new IllegalArgumentException("Неверный ввод данных.");

        return randomizedSelect(A, 0, A.length - 1, i);
    }
}
