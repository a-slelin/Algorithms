package a.slelin.work.algorithms.acmp.task0683;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line1 = reader.readLine();
        if (line1 == null) {
            reader.close();
            return;
        }
        int n = Integer.parseInt(line1.trim());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer("");
        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            if (st.hasMoreTokens()) {
                a[i] = Integer.parseInt(st.nextToken());
            }
        }
        reader.close();

        int result = solve(n, a);

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.print(result);
        writer.close();
    }

    public static int solve(int n, int[] a) {
        if (n < 3) {
            return 0;
        }

        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                int minPenalty = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int currentPenalty = dp[i][k] + dp[k][j] + a[k] * (a[i] + a[j]);
                    if (currentPenalty < minPenalty) {
                        minPenalty = currentPenalty;
                    }
                }
                dp[i][j] = minPenalty;
            }
        }

        return dp[0][n - 1];
    }
}