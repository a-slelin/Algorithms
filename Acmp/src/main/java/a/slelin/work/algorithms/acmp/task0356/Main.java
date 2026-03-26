package a.slelin.work.algorithms.acmp.task0356;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int e = sc.nextInt();
        int f = sc.nextInt();
        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();
        int[][] coins = new int[n][2];
        for (int i = 0; i < n; i++) {
            coins[i][0] = sc.nextInt();
            coins[i][1] = sc.nextInt();
        }
        sc.close();

        String result = solve(e, f, n, coins);

        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        pw.print(result);
        pw.close();
    }

    public static String solve(int e, int f, int n, int[][] coins) {
        int targetWeight = f - e;
        if (targetWeight == 0) return "0 0";

        long[] dpMin = new long[targetWeight + 1];
        long[] dpMax = new long[targetWeight + 1];
        long INF = 1_000_000_000_000L;

        Arrays.fill(dpMin, INF);
        Arrays.fill(dpMax, -1);
        dpMin[0] = 0;
        dpMax[0] = 0;

        for (int i = 0; i < n; i++) {
            int p = coins[i][0];
            int w = coins[i][1];
            for (int j = w; j <= targetWeight; j++) {
                if (dpMin[j - w] != INF) {
                    if (dpMin[j - w] + p < dpMin[j]) {
                        dpMin[j] = dpMin[j - w] + p;
                    }
                }
                if (dpMax[j - w] != -1) {
                    if (dpMax[j - w] + p > dpMax[j]) {
                        dpMax[j] = dpMax[j - w] + p;
                    }
                }
            }
        }

        if (dpMin[targetWeight] == INF) {
            return "This is impossible.";
        } else {
            return dpMin[targetWeight] + " " + dpMax[targetWeight];
        }
    }
}