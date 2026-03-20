package a.slelin.work.algorithms.acmp.task0500;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        if (firstLine == null) return;

        int n = Integer.parseInt(firstLine.trim());
        int[][] agents = new int[n][2];

        int count = 0;
        while (count < n) {
            String line = reader.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                agents[count][0] = Integer.parseInt(st.nextToken());
                agents[count][1] = Integer.parseInt(st.nextToken());
                count++;
            }
        }

        PrintWriter writer = new PrintWriter(System.out);
        writer.println(solve(n, agents));
        writer.close();
        reader.close();
    }

    public static long solve(int n, int[][] agents) {
        Arrays.sort(agents, Comparator.comparingInt(a -> a[0]));

        long[] dp = new long[n + 1];
        dp[2] = agents[1][1];

        if (n > 2) {
            dp[3] = (long) agents[1][1] + agents[2][1];
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + agents[i - 1][1];
        }

        return dp[n];
    }
}