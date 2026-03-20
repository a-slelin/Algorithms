package a.slelin.work.algorithms.acmp.task0373;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.print(solve(n, k, matrix));
        writer.close();
        sc.close();
    }

    public static long solve(int n, int k, int[][] matrix) {
        long[][] dp = new long[n][n];
        long[][] nextDp = new long[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = matrix[0][0];

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        for (int step = 2; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(nextDp[i], -1);
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] == -1) continue;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                            long sum = dp[r][c] + matrix[nr][nc];
                            if (sum > nextDp[nr][nc]) {
                                nextDp[nr][nc] = sum;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                System.arraycopy(nextDp[i], 0, dp[i], 0, n);
            }
        }

        long max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}