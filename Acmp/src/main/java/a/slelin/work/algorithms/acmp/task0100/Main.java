package a.slelin.work.algorithms.acmp.task0100;

import java.io.*;
import java.math.BigInteger;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        int n = Integer.parseInt(reader.readLine().trim());

        BigInteger result = solve(n);

        writer.println(result);
    }

    public static BigInteger solve(int n) {
        int k = n / 2;
        int maxSum = k * 9;

        BigInteger[][] dp = new BigInteger[k + 1][maxSum + 1];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= maxSum; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }

        dp[0][0] = BigInteger.ONE;

        for (int i = 1; i <= k; i++) {
            for (int s = 0; s <= i * 9; s++) {
                for (int d = 0; d <= 9; d++) {
                    if (s >= d) {
                        dp[i][s] = dp[i][s].add(dp[i - 1][s - d]);
                    }
                }
            }
        }

        BigInteger result = BigInteger.ZERO;
        for (int s = 0; s <= maxSum; s++) {
            BigInteger count = dp[k][s];
            result = result.add(count.multiply(count));
        }

        return result;
    }
}