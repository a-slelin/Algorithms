package a.slelin.work.algorithms.acmp.task0183;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String[] digits = reader.readLine().split(" ");
        int K = Integer.parseInt(digits[0]);
        int P = Integer.parseInt(digits[1]);

        long result = solve(K, P);

        writer.println(result);
    }

    public static long solve(int K, int P) {
        if (K < 2) return 0;
        long[] dp = new long[K + 1];
        dp[2] = 1 % P;
        for (int i = 3; i <= K; i++) {
            dp[i] = dp[i - 1];
            if (i % 2 == 0) {
                dp[i] += dp[i / 2];
            }
            dp[i] %= P;
        }
        return dp[K];
    }
}
