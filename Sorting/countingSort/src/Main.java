public class Main {
    public static int[] COUNTING_SORT(int[] A, int min, int max) {
        int[] C = new int[max - min + 1], B = new int[A.length];
        for (int i = 0; i < A.length; ++i)
            ++C[A[i] - min];
        for (int i = 1; i <= max - min; ++i)
            C[i] += C[i - 1];

        for (int i = A.length - 1; i >= 0; --i)
            B[--C[A[i] - min]] = A[i];
        return B;
    }

    public static int[] SORT(int[] A, boolean reverse) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; ++i) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        int[] B = COUNTING_SORT(A, min, max);
        if (reverse) {
            for (int i = 0; i < B.length / 2; ++i) {
                int tmp = B[i];
                B[i] = B[B.length - i - 1];
                B[B.length - i - 1] = tmp;
            }
        }

        return B;
    }

    public static void PRINT(int[] A) {
        for (int i = 0; i < A.length; ++i)
            System.out.print(A[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = {-2, 5, 3, 2, 2, 3, 5, 3, 3, 6, 0, -1};

        PRINT(A);
        int[] B = SORT(A, false);
        PRINT(B);
    }
}
