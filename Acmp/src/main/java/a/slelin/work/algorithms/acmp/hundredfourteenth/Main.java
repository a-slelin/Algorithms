package a.slelin.work.algorithms.acmp.hundredfourteenth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Main {
    static void main() {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {

            String[] digits = br.readLine().split(" ");
            int N = Integer.parseInt(digits[0]);
            int K = Integer.parseInt(digits[1]);

            BigInteger result = solve(N, K);

            printWriter.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
