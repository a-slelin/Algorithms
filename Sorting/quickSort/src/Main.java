import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static int PARTITION(int[] A, int p, int r, boolean reverse) {
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

    public static int RANDOMIZED_PARTITION(int[] A, int p, int r, boolean reverse) {
        int i = ThreadLocalRandom.current().nextInt(p, r + 1);

        int tmp = A[r];
        A[r] = A[i];
        A[i] = tmp;

        return PARTITION(A, p, r, reverse);
    }

    public static void QUICKSORT(int[] A, int p, int r, boolean reverse, boolean randomized) {
        if (p < r) {
            int q;
            if (randomized) q = RANDOMIZED_PARTITION(A, p, r, reverse);
            else q = PARTITION(A, p, r, reverse);
            QUICKSORT(A, p, q - 1, reverse, randomized);
            QUICKSORT(A, q + 1, r, reverse, randomized);
        }
    }

    public static void SORT(int[] A, boolean reverse, boolean randomized) {
        QUICKSORT(A, 0, A.length - 1, reverse, randomized);
    }

    public static void PRINT(int[] A) {
        for (int i = 0; i < A.length; ++i) 
            System.out.print(A[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = {8, 3, 12, 16, 10, 4, 1, 9, 7, 14};

        PRINT(A);
        SORT(A, false, false);
        PRINT(A);
    }
}
