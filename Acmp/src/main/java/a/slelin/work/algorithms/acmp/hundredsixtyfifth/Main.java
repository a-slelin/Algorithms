package a.slelin.work.algorithms.acmp.hundredsixtyfifth;

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

            int[][] field = new int[N][M];
            for (int i = 0; i < N; ++i) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < M; ++j) {
                    field[i][j] = Integer.parseInt(line[j]);
                }
            }

            long result = solve(N, M, field);

            printWriter.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static long solve(int N, int M, int[][] field) {
        int[][] dp = new int[N][M];
        dp[0][0] = 1;

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {

                if (dp[i][j] == 0 || (i == N - 1 && j == M - 1)) {
                    continue;
                }

                int step = field[i][j];

                if (i + step < N) {
                    dp[i + step][j] += dp[i][j];
                }

                if (j + step < M) {
                    dp[i][j + step] += dp[i][j];
                }
            }
        }

        return dp[N - 1][M - 1];
    }
}
