package a.slelin.work.algorithms.acmp.task0728;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] packs = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            packs[i][0] = Integer.parseInt(st.nextToken());
            packs[i][1] = Integer.parseInt(st.nextToken());
        }

        writer.print(solve(n, m, packs));

        reader.close();
        writer.close();
    }

    public static int solve(int n, int m, int[][] packs) {
        int[] dp = new int[n + 1];
        int INF = 1_000_000_000;
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            int a = packs[i][0];
            int b = packs[i][1];
            for (int j = 0; j <= n; j++) {
                if (dp[j] != INF) {
                    int next = Math.min(n, j + a);
                    if (dp[next] > dp[j] + b) {
                        dp[next] = dp[j] + b;
                    }
                }
            }
            for (int j = 0; j <= n; j++) {
                if (dp[j] != INF) {
                    int next = Math.min(n, j + a);
                    if (dp[next] > dp[j] + b) {
                        dp[next] = dp[j] + b;
                    }
                }
            }
            for (int j = 0; j <= n; j++) {
                if (dp[j] != INF) {
                    int next = Math.min(n, j + a);
                    if (dp[next] > dp[j] + b) {
                        dp[next] = dp[j] + b;
                    }
                }
            }
            for (int k = 0; k < 15; k++) {
                for (int j = 0; j <= n; j++) {
                    if (dp[j] != INF) {
                        int next = Math.min(n, j + a);
                        if (dp[next] > dp[j] + b) {
                            dp[next] = dp[j] + b;
                        }
                    }
                }
            }
        }
        return dp[n];
    }
}