package a.slelin.work.algorithms.acmp.task0335;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            writer.print(solve(n));
        }

        reader.close();
        writer.close();
    }

    public static long solve(int n) {
        long mod = 1000000009L;
        boolean[] isP = new boolean[1000];
        for (int i = 100; i < 1000; i++) {
            boolean p = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    p = false;
                    break;
                }
            }
            isP[i] = p;
        }

        long[] dp = new long[100];
        for (int i = 100; i < 1000; i++) {
            if (isP[i]) {
                dp[i % 100]++;
            }
        }

        for (int i = 4; i <= n; i++) {
            long[] next = new long[100];
            for (int s = 0; s < 100; s++) {
                if (dp[s] == 0) continue;
                for (int d = 0; d <= 9; d++) {
                    int num = s * 10 + d;
                    if (isP[num]) {
                        int ns = num % 100;
                        next[ns] = (next[ns] + dp[s]) % mod;
                    }
                }
            }
            dp = next;
        }

        long sum = 0;
        for (long v : dp) {
            sum = (sum + v) % mod;
        }
        return sum;
    }
}