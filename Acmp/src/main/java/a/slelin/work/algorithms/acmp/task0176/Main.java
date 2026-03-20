package a.slelin.work.algorithms.acmp.task0176;

import java.io.*;
import java.math.BigInteger;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            String[] parts = line.split(" ");
            int n = Integer.parseInt(parts[0]);
            int k = Integer.parseInt(parts[1]);

            writer.println(solve(n, k));
        }

        reader.close();
        writer.close();
    }

    public static BigInteger solve(int n, int k) {
        return count(n, k).subtract(count(n, k - 1));
    }

    private static BigInteger count(int n, int k) {
        if (k < 0) return BigInteger.ZERO;
        if (k > n) k = n;

        BigInteger[][] dp = new BigInteger[2 * n + 1][k + 1];
        for (int i = 0; i <= 2 * n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }

        dp[0][0] = BigInteger.ONE;

        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j].equals(BigInteger.ZERO)) continue;

                if (j + 1 <= k) {
                    dp[i + 1][j + 1] = dp[i + 1][j + 1].add(dp[i][j]);
                }
                if (j - 1 >= 0) {
                    dp[i + 1][j - 1] = dp[i + 1][j - 1].add(dp[i][j]);
                }
            }
        }

        return dp[2 * n][0];
    }
}