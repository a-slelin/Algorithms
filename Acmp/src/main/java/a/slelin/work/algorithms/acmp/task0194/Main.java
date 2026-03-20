package a.slelin.work.algorithms.acmp.task0194;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        int n = Integer.parseInt(reader.readLine());

        long result = Main.solve(n);

        writer.println(result);
    }

    public static long solve(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + 1;
        }

        return dp[n];
    }
}