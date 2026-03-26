package a.slelin.work.algorithms.acmp.task0553;

import java.io.*;
import java.util.Scanner;

public class Main {

    static void main() throws IOException {
        File inputFile = new File("input.txt");

        Scanner sc = new Scanner(inputFile);
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }

        int n = sc.nextInt();
        int[] m = new int[n + 1];
        int[] k = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            m[i] = sc.nextInt();
            k[i] = sc.nextInt();
        }
        sc.close();

        long result = solve(n, m, k);

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        out.println(result);
        out.close();
    }

    public static long solve(int n, int[] m, int[] k) {
        if (n <= 1) return 0;

        long[][] dp = new long[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                long minInternal = Long.MAX_VALUE;
                for (int split = i; split < j; split++) {
                    long current = dp[i][split] + dp[split + 1][j];
                    if (current < minInternal) {
                        minInternal = current;
                    }
                }
                dp[i][j] = minInternal + (long) m[i] * k[j];
            }
        }

        return dp[1][n];
    }
}