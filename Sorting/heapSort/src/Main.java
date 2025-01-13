public class Main {
    public static void HEAPIFY(int[] A, int i, int heap_size, boolean reverse) {
        int l = (i << 1) + 1, r = l + 1, swapped = i;

        if (l < heap_size && (reverse ? A[l] < A[swapped] : A[l] > A[swapped])) swapped = l;
        if (r < heap_size && (reverse ? A[r] < A[swapped] : A[r] > A[swapped])) swapped = r;

        if (swapped != i) {
            int tmp = A[i];
            A[i] = A[swapped];
            A[swapped] = tmp;

            HEAPIFY(A, swapped, heap_size, reverse);
        }
    }
    public static void BUILD_HEAP(int[] A, int heap_size, boolean reverse) {
        for (int i = A.length / 2; i >= 0; --i)
            HEAPIFY(A, i, heap_size, reverse);
    }

    public static void HEAPSORT(int[] A, boolean reverse) {
        int heap_size = A.length;
        BUILD_HEAP(A, heap_size, reverse);
        for (int i = A.length - 1; i >= 1; --i) {
            int tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;

            HEAPIFY(A, 0, --heap_size, reverse);
        }
    }
    public static void PRINT(int[] A) {
        for (int i = 0; i < A.length; ++i)
            System.out.print(A[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = {8, 3, 12, 16, 10, 4, 1, 9, 7, 14};

        PRINT(A);
        HEAPSORT(A, false);
        PRINT(A);
    }
}
