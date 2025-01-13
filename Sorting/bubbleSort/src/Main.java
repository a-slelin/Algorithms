public class Main {
    public static void print(int[] A){
        for(int a : A){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] A, boolean reverse){
        int n = A.length - 1;

        for(int i = 0; i <= n - 2; ++i){
            boolean swapped = false;

            for(int j = n; j > i; --j){
                if(reverse ? A[j] > A[j - 1]
                        : A[j] < A[j - 1]) {
                    int tmp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = tmp;

                    swapped = true;
                }
            }

            if(!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] A = {8, 3, 12, 16, 10, 4, 1, 9, 7, 14};
        boolean reverse = true;
        System.out.println("Before:");
        print(A);

        bubbleSort(A, reverse);

        System.out.println("After:");
        print(A);
    }
}
