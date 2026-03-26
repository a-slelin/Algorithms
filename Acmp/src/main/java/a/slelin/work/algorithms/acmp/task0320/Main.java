package a.slelin.work.algorithms.acmp.task0320;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (st.hasMoreTokens()) {
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                writer.print(solve(m, n));
            }
        }

        reader.close();
        writer.close();
    }

    public static long solve(int m, int n) {
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            if (i >= m) {
                dp[i] += dp[i - m];
            }
        }

        return dp[n];
    }
}