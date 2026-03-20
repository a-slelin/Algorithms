package a.slelin.work.algorithms.acmp.task0120;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String[] digits = reader.readLine().split(" ");
        int N = Integer.parseInt(digits[0]);
        int M = Integer.parseInt(digits[1]);

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = reader.readLine().trim().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        long result = solve(N, M, matrix);

        writer.println(result);
    }

    public static long solve(int N, int M, int[][] matrix) {
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (i == 0) {
                    dp[i][j] = matrix[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = matrix[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[N - 1][M - 1];
    }
}
