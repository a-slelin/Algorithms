package a.slelin.work.algorithms.acmp.task0011;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String[] digits = reader.readLine().split(" ");
        int K = Integer.parseInt(digits[0]);
        int N = Integer.parseInt(digits[1]);

        BigInteger result = solve(K, N);
        writer.println(result);
    }

    public static BigInteger solve(int K, int N) {
        BigInteger[] array = new BigInteger[N + 1];
        Arrays.fill(array, BigInteger.ZERO);
        array[0] = BigInteger.ONE;

        for (int i = 0; i <= N; i++) {
            for (int j = i + 1; j <= Math.min(i + K, N); j++) {
                array[j] = array[j].add(array[i]);
            }
        }

        return array[N];
    }
}
