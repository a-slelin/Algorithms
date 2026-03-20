package a.slelin.work.algorithms.acmp.task0104;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String s1 = reader.readLine();
        String s2 = reader.readLine();

        if (s1 != null && s2 != null) {
            s1 = s1.trim();
            s2 = s2.trim();

            String p, w;
            if (s2.contains("*") || s2.contains("?")) {
                p = s2;
                w = s1;
            } else {
                p = s1;
                w = s2;
            }

            boolean result = solve(p, w);
            writer.println(result ? "YES" : "NO");
        }

        reader.close();
        writer.close();
    }

    public static boolean solve(String p, String w) {
        int n = p.length();
        int m = w.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            } else {
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pc = p.charAt(i - 1);
                if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pc == '?' || pc == w.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }
}