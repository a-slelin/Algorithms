package a.slelin.work.algorithms.acmp.task0247;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                String priceLine = reader.readLine();
                if (priceLine != null) {
                    prices[i] = Integer.parseInt(priceLine.trim());
                }
            }

            int[] result = solve(n, prices);
            writer.println(result[0]);
            writer.println(result[1] + " " + result[2]);
        }

        reader.close();
        writer.close();
    }

    public static int[] solve(int n, int[] prices) {
        if (n == 0) {
            return new int[]{0, 0, 0};
        }

        int INF = 1000000;
        int[][] dp = new int[n + 1][n + 2];
        int[][] parent = new int[n + 1][n + 2];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int p = prices[i - 1];
            for (int j = 0; j <= n; j++) {
                if (p > 100) {
                    if (j > 0 && dp[i - 1][j - 1] != INF) {
                        dp[i][j] = dp[i - 1][j - 1] + p;
                        parent[i][j] = j - 1;
                    }
                } else {
                    if (dp[i - 1][j] != INF) {
                        dp[i][j] = dp[i - 1][j] + p;
                        parent[i][j] = j;
                    }
                }

                if (dp[i - 1][j + 1] != INF && dp[i - 1][j + 1] <= dp[i][j]) {
                    dp[i][j] = dp[i - 1][j + 1];
                    parent[i][j] = j + 1;
                }
            }
        }

        int minCost = INF;
        int k1 = 0;
        for (int j = 0; j <= n; j++) {
            if (dp[n][j] <= minCost) {
                minCost = dp[n][j];
                k1 = j;
            }
        }

        int k2 = 0;
        int currentJ = k1;
        for (int i = n; i >= 1; i--) {
            int prevJ = parent[i][currentJ];
            if (prevJ == currentJ + 1) {
                k2++;
            }
            currentJ = prevJ;
        }

        return new int[]{minCost, k1, k2};
    }
}