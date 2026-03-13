package a.slelin.work.algorithms.acmp.hundredtwentythird;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    static void main() {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {

            String str = br.readLine();

            BigInteger result = solve(str);

            printWriter.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static BigInteger solve(String pattern) {
        int n = pattern.length();
        if (n == 0) return BigInteger.ONE;

        BigInteger[][] dp = new BigInteger[n + 1][n + 2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n + 1; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }
        dp[0][0] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            char c = pattern.charAt(i - 1);
            for (int j = 0; j <= n; j++) {
                BigInteger val = dp[i - 1][j];
                if (val.equals(BigInteger.ZERO)) continue;

                if (c == '(' || c == '?') {
                    dp[i][j + 1] = dp[i][j + 1].add(val);
                }
                if (c == ')' || c == '?') {
                    if (j > 0) {
                        dp[i][j - 1] = dp[i][j - 1].add(val);
                    }
                }
            }
        }

        return dp[n][0];
    }
}
