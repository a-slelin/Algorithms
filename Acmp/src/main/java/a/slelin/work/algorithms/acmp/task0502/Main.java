package a.slelin.work.algorithms.acmp.task0502;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++) {
                String rowLine = reader.readLine();
                if (rowLine != null) {
                    StringTokenizer st = new StringTokenizer(rowLine);
                    for (int j = 0; j < n; j++) {
                        if (st.hasMoreTokens()) {
                            a[i][j] = Integer.parseInt(st.nextToken());
                        }
                    }
                }
            }
            writer.print(solve(n, a));
        }

        reader.close();
        writer.close();
    }

    public static int solve(int n, int[][] a) {
        int[][] dp = new int[n + 1][n + 1];
        int INF = -1;

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int j = 1; j <= n; j++) {
            for (int s = 0; s <= n; s++) {
                dp[j][s] = dp[j - 1][s];

                for (int r = 1; r <= s; r++) {
                    if (dp[j - 1][s - r] != INF) {
                        int currentWeight = dp[j - 1][s - r] + a[r - 1][j - 1];
                        if (currentWeight > dp[j][s]) {
                            dp[j][s] = currentWeight;
                        }
                    }
                }
            }
        }

        return dp[n][n];
    }
}