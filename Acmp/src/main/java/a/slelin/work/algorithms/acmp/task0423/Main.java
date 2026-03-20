package a.slelin.work.algorithms.acmp.task0423;

import java.io.*;
import java.math.BigInteger;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String s = reader.readLine();
        if (s != null) {
            writer.print(solve(s.trim()));
        }

        reader.close();
        writer.close();
    }

    public static BigInteger solve(String s) {
        int n = s.length();
        if (n == 0) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            if (i >= 2) {
                int val = Integer.parseInt(s.substring(i - 2, i));
                if (val >= 10 && val <= 33) {
                    dp[i] = dp[i].add(dp[i - 2]);
                }
            }
        }

        return dp[n];
    }
}