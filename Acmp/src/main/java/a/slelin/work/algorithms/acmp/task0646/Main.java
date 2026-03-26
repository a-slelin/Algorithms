package a.slelin.work.algorithms.acmp.task0646;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();

        long result = solve(n, k, a);

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.print(result);
        writer.close();
    }

    public static long solve(int n, int k, long[] a) {
        long totalSum = 0;
        for (long val : a) {
            totalSum += val;
        }

        long[] dp = new long[k];
        dp[0] = 1;

        for (long val : a) {
            if (val < k) {
                int vInt = (int) val;
                for (int v = k - 1; v >= vInt; v--) {
                    dp[v] += dp[v - vInt];
                }
            }
        }

        long sumLow = 0;
        for (int i = 0; i < k; i++) {
            sumLow += dp[i];
        }

        long totalWays = 1L << n;

        long lowerBound = totalSum - k + 1;
        long sumOverlap = 0;
        if (lowerBound < k) {
            int start = (int) Math.max(0, lowerBound);
            for (int i = start; i < k; i++) {
                sumOverlap += dp[i];
            }
        }

        return totalWays - 2 * sumLow + sumOverlap;
    }
}