public class Main {
    public static void print(int[] A){
        for(int arg : A){
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] A, boolean reverse){
        for (int i = 1; i < A.length; ++i) {
            int j = i - 1, key = A[i];
            while (j >= 0 && (reverse ? A[j] < key : A[j] > key))
                A[j + 1] = A[j--];

            A[++j] = key;
        }
    }

    public static void main(String[] args) {
        int[] A = {8, 3, 12, 16, 10, 4, 1, 9, 7, 14};
        boolean reverse = false;

        System.out.println("Before:");
        print(A);

        insertionSort(A, reverse);

        System.out.println("After:");
        print(A);
    }
}
