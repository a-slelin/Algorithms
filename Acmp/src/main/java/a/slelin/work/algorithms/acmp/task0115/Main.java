package a.slelin.work.algorithms.acmp.task0115;

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
        int maxSum = Integer.MIN_VALUE;
        for (int top = 0; top < N; top++) {
            int[] colSum = new int[M];
            for (int bottom = top; bottom < N; bottom++) {
                for (int col = 0; col < M; col++) {
                    colSum[col] += matrix[bottom][col];
                }
                int currentSum = colSum[0];
                int bestSum = colSum[0];
                for (int col = 1; col < M; col++) {
                    currentSum = Math.max(colSum[col], currentSum + colSum[col]);
                    bestSum = Math.max(bestSum, currentSum);
                }
                maxSum = Math.max(maxSum, bestSum);
            }
        }
        return maxSum;
    }
}
