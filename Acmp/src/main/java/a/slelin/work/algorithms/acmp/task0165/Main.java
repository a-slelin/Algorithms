package a.slelin.work.algorithms.acmp.task0165;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String[] digits = reader.readLine().split(" ");
        int N = Integer.parseInt(digits[0]);
        int M = Integer.parseInt(digits[1]);

        int[][] field = new int[N][M];
        for (int i = 0; i < N; ++i) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < M; ++j) {
                field[i][j] = Integer.parseInt(line[j]);
            }
        }

        long result = solve(N, M, field);

        writer.println(result);
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
