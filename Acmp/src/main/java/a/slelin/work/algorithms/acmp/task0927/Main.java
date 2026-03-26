package a.slelin.work.algorithms.acmp.task0927;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String cStr = reader.readLine();
        if (cStr == null) {
            writer.close();
            reader.close();
            return;
        }
        cStr = cStr.trim();
        if (cStr.isEmpty()) {
            writer.close();
            reader.close();
            return;
        }

        int result = solve(cStr);
        writer.print(result);

        writer.close();
        reader.close();
    }

    public static int solve(String cStr) {
        int n = cStr.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = cStr.charAt(n - 1 - i) - '0';
        }

        final int MOD = 1000000007;
        int[][][] dp = new int[2][11][11];
        int[][][] nextDp = new int[2][11][11];

        dp[0][10][10] = 1;

        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 2; c++) {
                for (int a = 0; a < 11; a++) {
                    Arrays.fill(nextDp[c][a], 0);
                }
            }

            int ci = digits[i];
            boolean isLeftmost = (i == n - 1);

            for (int carryIn = 0; carryIn < 2; carryIn++) {
                for (int lastA = 0; lastA <= 10; lastA++) {
                    for (int lastB = 0; lastB <= 10; lastB++) {
                        int currentWays = dp[carryIn][lastA][lastB];
                        if (currentWays == 0) continue;

                        for (int nextCarry = 0; nextCarry < 2; nextCarry++) {
                            if (isLeftmost && nextCarry != 0) continue;

                            int target = ci + 10 * nextCarry - carryIn;
                            if (target < 0 || target > 18) continue;

                            int minA = Math.max(0, target - 9);
                            int maxA = Math.min(9, target);

                            for (int a = minA; a <= maxA; a++) {
                                int b = target - a;

                                if (a == lastA || b == lastB) continue;

                                if (isLeftmost && (a == 0 || b == 0)) continue;

                                int val = nextDp[nextCarry][a][b] + currentWays;
                                if (val >= MOD) val -= MOD;
                                nextDp[nextCarry][a][b] = val;
                            }
                        }
                    }
                }
            }
            int[][][] temp = dp;
            dp = nextDp;
            nextDp = temp;
        }

        int total = 0;
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                total += dp[0][a][b];
                if (total >= MOD) total -= MOD;
            }
        }

        return total;
    }
}