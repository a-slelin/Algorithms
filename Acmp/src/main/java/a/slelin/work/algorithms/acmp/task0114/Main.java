package a.slelin.work.algorithms.acmp.task0114;

import java.io.*;
import java.math.BigInteger;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String[] digits = reader.readLine().split(" ");
        int N = Integer.parseInt(digits[0]);
        int K = Integer.parseInt(digits[1]);

        BigInteger result = solve(N, K);

        writer.println(result);
    }

    public static BigInteger solve(int N, int K) {
        BigInteger prevEndWithZero = BigInteger.ONE;
        BigInteger prevEndWithNonZero = BigInteger.valueOf(K - 1);

        for (int i = 2; i <= N; i++) {
            BigInteger currentEndWithZero = prevEndWithNonZero;
            BigInteger currentEndWithNonZero = prevEndWithZero
                    .add(prevEndWithNonZero)
                    .multiply(BigInteger.valueOf(K - 1));

            prevEndWithZero = currentEndWithZero;
            prevEndWithNonZero = currentEndWithNonZero;
        }

        return prevEndWithNonZero;
    }
}
