package a.slelin.work.algorithms.sort.heap;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HeapSort {

    public static void heapify(int[] A, int i, int heap_size, boolean reverse) {
        int l = (i << 1) + 1, r = l + 1, swapped = i;

        if (l < heap_size && (reverse ? A[l] < A[swapped] : A[l] > A[swapped])) swapped = l;
        if (r < heap_size && (reverse ? A[r] < A[swapped] : A[r] > A[swapped])) swapped = r;

        if (swapped != i) {
            int tmp = A[i];
            A[i] = A[swapped];
            A[swapped] = tmp;

            heapify(A, swapped, heap_size, reverse);
        }
    }

    public static void buildHeap(int[] A, int heap_size, boolean reverse) {
        for (int i = A.length / 2; i >= 0; --i)
            heapify(A, i, heap_size, reverse);
    }

    public static void sort(int[] A) {
        sort(A, false);
    }

    public static void sort(int[] A, boolean reverse) {
        int heap_size = A.length;
        buildHeap(A, heap_size, reverse);
        for (int i = A.length - 1; i >= 1; --i) {
            int tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;

            heapify(A, 0, --heap_size, reverse);
        }
    }
}
