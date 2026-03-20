package a.slelin.work.algorithms.acmp.task0787;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            int[] a = new int[n];

            StringTokenizer st = null;
            for (int i = 0; i < n; i++) {
                while (st == null || !st.hasMoreTokens()) {
                    String nextLine = reader.readLine();
                    if (nextLine == null) break;
                    st = new StringTokenizer(nextLine);
                }
                if (st != null && st.hasMoreTokens()) {
                    a[i] = Integer.parseInt(st.nextToken());
                }
            }

            writer.print(solve(n, a));
        }

        reader.close();
        writer.close();
    }

    public static int solve(int n, int[] a) {
        if (n == 1) return a[0];

        int[] dp = new int[n];
        System.arraycopy(a, 0, dp, 0, n);

        for (int k = 1; k < n; k++) {
            int turn = n - k;
            boolean isPlayer1 = (turn % 2 != 0);

            for (int i = 0; i < n - k; i++) {
                if (isPlayer1) {
                    dp[i] = Math.max(dp[i], dp[i + 1]);
                } else {
                    dp[i] = Math.min(dp[i], dp[i + 1]);
                }
            }
        }

        return dp[0];
    }
}