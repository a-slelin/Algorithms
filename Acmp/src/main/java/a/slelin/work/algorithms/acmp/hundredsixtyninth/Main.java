package a.slelin.work.algorithms.acmp.hundredsixtyninth;

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
        if (K < N || (K - N) % 2 != 0) {
            return BigInteger.ZERO;
        }
        int m = (K + N) / 2;
        BigInteger c = binomial(K, m);
        return c.multiply(BigInteger.valueOf(N)).divide(BigInteger.valueOf(K));
    }

    private static BigInteger binomial(int n, int k) {
        if (k < 0 || k > n) return BigInteger.ZERO;
        if (k > n - k) k = n - k;
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            res = res.multiply(BigInteger.valueOf(n - k + i))
                    .divide(BigInteger.valueOf(i));
        }
        return res;
    }
}
