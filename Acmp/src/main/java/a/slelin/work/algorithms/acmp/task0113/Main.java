package a.slelin.work.algorithms.acmp.task0113;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        int n = Integer.parseInt(reader.readLine().trim());

        int[][] plot = new int[n][n];
        for (int i = 0; i < n; ++i) {
            String line = reader.readLine().trim();
            for (int j = 0; j < n; ++j) {
                plot[i][j] = line.charAt(j) - '0';
            }
        }

        long result = solve(n, plot);

        writer.println(result);
    }

    public static long solve(int n, int[][] plot) {
        int[][] dp = new int[n][n];
        long result = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (plot[i][j] == 1) {

                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }

                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }
}
