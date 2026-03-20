package a.slelin.work.algorithms.acmp.task0369;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            @SuppressWarnings("unused") int tLimit = Integer.parseInt(st.nextToken());

            int[] t = readArr(reader, n);
            int[] p = readArr(reader, n);
            int[] s = readArr(reader, n);

            writer.print(solve(n, k, t, p, s));
        }

        reader.close();
        writer.close();
    }

    private static int[] readArr(BufferedReader r, int n) throws IOException {
        int[] res = new int[n];
        int count = 0;
        while (count < n) {
            String line = r.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) res[count++] = Integer.parseInt(st.nextToken());
        }
        return res;
    }

    public static int solve(int n, @SuppressWarnings("unused") int k, int[] t, int[] p, int[] s) {
        int[][] g = new int[n][3];
        for (int i = 0; i < n; i++) {
            g[i][0] = t[i];
            g[i][1] = p[i];
            g[i][2] = s[i];
        }

        Arrays.sort(g, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            if (g[i][2] <= g[i][0]) dp[i] = g[i][1];

            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && Math.abs(g[i][2] - g[j][2]) <= g[i][0] - g[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + g[i][1]);
                }
            }
        }

        int max = 0;
        for (int v : dp) if (v > max) max = v;
        return max;
    }
}