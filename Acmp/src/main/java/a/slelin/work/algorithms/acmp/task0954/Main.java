package a.slelin.work.algorithms.acmp.task0954;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null && !line.trim().isEmpty()) {
            int k = Integer.parseInt(line.trim());
            writer.print(solve(k));
        }

        reader.close();
        writer.close();
    }

    public static int solve(int k) {
        int MOD = 1000000;

        int[] dp = new int[k + 1];

        dp[0] = 1;

        for (int i = 1; i <= k; i++) {
            long ways = 0;
            if (i >= 10) ways += dp[i - 10];
            if (i >= 11) ways += dp[i - 11];
            if (i >= 12) ways += dp[i - 12];

            dp[i] = (int) (ways % MOD);
        }

        return (int) ((dp[k] * 2L) % MOD);
    }
}