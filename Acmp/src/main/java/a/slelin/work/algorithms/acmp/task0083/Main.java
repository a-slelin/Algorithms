package a.slelin.work.algorithms.acmp.task0083;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String[] digits = reader.readLine().split(" ");
        int m = Integer.parseInt(digits[0]);
        int n = Integer.parseInt(digits[1]);

        long result = solve(m, n);
        writer.println(result);
    }

    public static long solve(int m, int n) {
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }

        if (m == 1) {
            return 1L << n;
        }

        int numMasks = 1 << m;
        long[][] dp = new long[n][numMasks];

        for (int mask = 0; mask < numMasks; mask++) {
            dp[0][mask] = 1;
        }

        for (int col = 1; col < n; col++) {
            for (int nextMask = 0; nextMask < numMasks; nextMask++) {
                for (int prevMask = 0; prevMask < numMasks; prevMask++) {
                    if (isValidTransition(prevMask, nextMask, m)) {
                        dp[col][nextMask] += dp[col - 1][prevMask];
                    }
                }
            }
        }

        long total = 0;
        for (int mask = 0; mask < numMasks; mask++) {
            total += dp[n - 1][mask];
        }

        return total;
    }

    private static boolean isValidTransition(int m1, int m2, int m) {
        for (int i = 0; i < m - 1; i++) {
            int b1 = (m1 >> i) & 1;
            int b2 = (m1 >> (i + 1)) & 1;
            int b3 = (m2 >> i) & 1;
            int b4 = (m2 >> (i + 1)) & 1;

            if (b1 == b2 && b2 == b3 && b3 == b4) {
                return false;
            }
        }
        return true;
    }
}