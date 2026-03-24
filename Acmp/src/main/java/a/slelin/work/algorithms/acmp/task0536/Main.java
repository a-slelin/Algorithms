package a.slelin.work.algorithms.acmp.task0536;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        if (!st.hasMoreTokens()) return;

        int n = Integer.parseInt(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] sArr = new char[n];
        int idx = 0;
        while (idx < n) {
            int ch = reader.read();
            if (ch == -1) break;
            if (ch >= '0' && ch <= '9') {
                sArr[idx++] = (char) ch;
            }
        }
        String s = new String(sArr);

        long result = solve(n, c, k, s);

        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        writer.println(result);
        writer.flush();
        writer.close();
        reader.close();
    }

    public static long solve(int n, long c, int k, String s) {
        if (n == 0) return 0;

        long mod = 1;
        for (int i = 0; i < k; i++) {
            mod *= 10;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            if (dp[i] == 0) continue;

            if (i < s.length() && s.charAt(i) == '0') {
                dp[i + 1] = (dp[i + 1] + dp[i]);
                if (dp[i + 1] >= mod) dp[i + 1] %= mod;
            } else if (i < s.length()) {
                long currentVal = 0;
                for (int len = 1; len <= 10; len++) {
                    int end = i + len;
                    if (end > n) break;

                    currentVal = currentVal * 10 + (s.charAt(end - 1) - '0');

                    if (currentVal <= c) {
                        dp[end] = (dp[end] + dp[i]);
                        if (dp[end] >= mod) dp[end] %= mod;
                    } else {
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}