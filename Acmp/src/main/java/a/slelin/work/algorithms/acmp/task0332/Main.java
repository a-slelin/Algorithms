package a.slelin.work.algorithms.acmp.task0332;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            int[][] cost = new int[n + 1][n + 1];

            StringBuilder sb = new StringBuilder();
            String l;
            while ((l = reader.readLine()) != null) {
                sb.append(l).append(" ");
            }
            StringTokenizer st = new StringTokenizer(sb.toString());

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (st.hasMoreTokens()) {
                        cost[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            writer.print(solve(n, cost));
        }

        reader.close();
        writer.close();
    }

    public static int solve(int n, int[][] cost) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000000000);
        dp[0] = 0;

        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] + cost[i][j] < dp[j]) {
                    dp[j] = dp[i] + cost[i][j];
                }
            }
        }

        return dp[n];
    }
}