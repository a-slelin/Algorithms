package a.slelin.work.algorithms.acmp.hundredfifteenth;

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
