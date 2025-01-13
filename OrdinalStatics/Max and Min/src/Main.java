public class Main {
    public static void main(String[] args) {
        int[] A = new int[]{8, 3, 12, 16, 10, 4, 1, 9, 7, 14};

        int max = A[0], min = A[0];
        for (int a : A){
            System.out.print(a + " ");
            max = (a > max) ? a : max;
            min = (a < min) ? a : min;
        }
        System.out.println();

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
