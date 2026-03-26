package a.slelin.work.algorithms.acmp.task0481;

import java.io.*;
import java.util.Scanner;

public class Main {

    static void main() throws IOException {
        File inputFile = new File("input.txt");
        if (!inputFile.exists()) return;

        Scanner sc = new Scanner(inputFile);
        if (!sc.hasNext()) {
            sc.close();
            return;
        }
        String s = sc.next();
        sc.close();

        long result = solve(s);

        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        out.print(result);
        out.close();
    }

    public static long solve(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();
        long[][] dp = new long[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][n - 1];
    }
}