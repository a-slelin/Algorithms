package a.slelin.work.algorithms.acmp.task0212;

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
        int p = Integer.parseInt(st.nextToken());

        int[][] edges = new int[n - 1][2];
        int edgeIdx = 0;
        while ((line = reader.readLine()) != null) {
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                edges[edgeIdx][0] = Integer.parseInt(st.nextToken());
                if (!st.hasMoreTokens()) break;
                edges[edgeIdx][1] = Integer.parseInt(st.nextToken());
                edgeIdx++;
            }
        }

        writer.print(solve(n, p, edges));
        writer.close();
        reader.close();
    }

    public static int solve(int n, int p, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            if (edge[0] == 0) continue;
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[][] dp = new int[n + 1][p + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], 1000);

        dfs(1, -1, p, adj, dp);

        int res = dp[1][p];
        for (int i = 2; i <= n; i++) {
            res = Math.min(res, dp[i][p] + 1);
        }
        return res;
    }

    private static void dfs(int u, int par, int p, List<Integer>[] adj, int[][] dp) {
        dp[u][1] = 0;
        for (int v : adj[u]) {
            if (v == par) continue;
            dfs(v, u, p, adj, dp);
            for (int i = p; i >= 1; i--) {
                dp[u][i]++;
                for (int j = 1; j < i; j++) {
                    dp[u][i] = Math.min(dp[u][i], dp[u][i - j] + dp[v][j]);
                }
            }
        }
    }
}