package a.slelin.work.algorithms.acmp.task0407;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append(" ");
        }
        StringTokenizer st = new StringTokenizer(sb.toString());

        if (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int k = Integer.parseInt(st.nextToken());

            writer.print(solve(n, a, k));
        }

        writer.close();
        reader.close();
    }

    public static int solve(@SuppressWarnings("unused") int n, int[] a, int k) {
        int[] dp = new int[k + 1];
        int INF = 1000001;
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int coin : a) {
                if (i >= coin) {
                    int prev = dp[i - coin];
                    if (prev + 1 < dp[i]) {
                        dp[i] = prev + 1;
                    }
                }
            }
        }

        return dp[k] == INF ? -1 : dp[k];
    }
}