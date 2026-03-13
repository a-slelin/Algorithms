package a.slelin.work.algorithms.acmp.thirtyeighth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
    static void main() {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {

            @SuppressWarnings("unused")
            int n = Integer.parseInt(br.readLine().trim());

            int[] numbers = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int result = solve(numbers);

            printWriter.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int solve(int[] numbers) {
        int n = numbers.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = numbers[i];
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i + length - 1 < n; i++) {
                int j = i + length - 1;
                int takeLeft = numbers[i] - dp[i + 1][j];
                int takeRight = numbers[j] - dp[i][j - 1];
                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }

        int difference = dp[0][n - 1];

        if (difference > 0) {
            return 1;
        } else if (difference < 0) {
            return 2;
        } else {
            return 0;
        }
    }
}
