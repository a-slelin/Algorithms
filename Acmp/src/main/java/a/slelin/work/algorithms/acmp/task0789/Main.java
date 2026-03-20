package a.slelin.work.algorithms.acmp.task0789;

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
        if (n <= 0) return 0;
        long[] dp = new long[n + 1];
        dp[1] = 1;

        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            long next2 = dp[i2] * 2;
            long next3 = dp[i3] * 3;
            long next5 = dp[i5] * 5;

            long next = Math.min(next2, Math.min(next3, next5));
            dp[i] = next;

            if (next == next2) i2++;
            if (next == next3) i3++;
            if (next == next5) i5++;
        }

        return dp[n];
    }
}