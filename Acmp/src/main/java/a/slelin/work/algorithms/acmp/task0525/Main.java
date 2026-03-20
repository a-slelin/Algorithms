package a.slelin.work.algorithms.acmp.task0525;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            writer.print(solve(n));
        }

        reader.close();
        writer.close();
    }

    public static long solve(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i / 2];
            }
        }

        return dp[n];
    }
}