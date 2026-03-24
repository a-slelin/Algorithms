package a.slelin.work.algorithms.acmp.task0480;

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
        int[] stacks = new int[n];
        for (int i = 0; i < n; i++) {
            stacks[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        int result = solve(n, stacks, k);

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.print(result);
        writer.close();
    }

    public static int solve(int n, int[] stacks, int k) {
        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + stacks[i];
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int l = 1; l <= n; l++) {
                if (l >= n - i) {
                    dp[i][l] = suffixSum[i];
                } else {
                    dp[i][l] = Math.max(dp[i][l - 1], suffixSum[i] - dp[i + l][l]);
                }
            }
        }

        return dp[0][Math.min(k, n)];
    }
}