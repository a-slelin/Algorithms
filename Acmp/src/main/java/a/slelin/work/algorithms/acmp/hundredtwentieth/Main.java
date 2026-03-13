package a.slelin.work.algorithms.acmp.hundredtwentieth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {
    static void main() {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {

            String[] digits = br.readLine().split(" ");
            int N = Integer.parseInt(digits[0]);
            int M = Integer.parseInt(digits[1]);

            int[][] matrix = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().trim().split(" ");
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }

            long result = solve(N, M, matrix);

            printWriter.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
