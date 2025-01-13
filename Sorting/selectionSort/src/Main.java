public class Main {
    public static void selectionSort(int[] A, boolean reverse) {
        for (int i = 0; i < A.length - 1; ++i) {
            int index = i;
            for (int j = i; j < A.length; ++j)
                if (reverse ? A[index] < A[j] : A[index] > A[j]) index = j;

            int tmp = A[i];
            A[i] = A[index];
            A[index] = tmp;
        }
    }

    public static void print(int[] A) {
        for (int i = 0; i < A.length; ++i)
            System.out.print(A[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = {8, 3, 12, 16, 10, 4, 1, 9, 7, 14};

        print(A);
        selectionSort(A, false);
        print(A);
    }
}
