public class Main {
    public static void merge(int[] A, int p, int q, int r, boolean reverse) {
        int len1 = q - p + 1, len2 = r - q;
        int[] L = new int[len1 + 1], R = new int[len2 + 1];
        for (int i = 0; i < len1; ++i)
            L[i] = A[i + p];
        for (int i = 0; i < len2; ++i)
            R[i] = A[i + q + 1];
        L[len1] = R[len2] = reverse ? Integer.MIN_VALUE  : Integer.MAX_VALUE;

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
    public static void sort(int[] A, boolean reverse) {
        mergeSort(A, 0, A.length - 1, reverse);
    }

    public static void print(int[] A) {
        for (int i = 0; i < A.length; ++i)
            System.out.print(A[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = {8, 3, 12, 16, 10, 4, 1, 9, 7, 14};

        print(A);
        sort(A, false);
        print(A);
    }
}
