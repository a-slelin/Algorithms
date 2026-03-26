package a.slelin.work.algorithms.acmp.task0476;

import java.io.*;
import java.util.Scanner;

public class Main {

    static void main() throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        if (!sc.hasNextInt()) return;
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        int result = solve(m, n);

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.print(result);
        writer.close();
    }

    public static int solve(int m, int n) {
        boolean[][] win = new boolean[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    win[i][j] = false;
                    continue;
                }

                boolean canReachP = false;

                for (int k = 1; k < j; k++) {
                    if (!win[i][j - k]) {
                        canReachP = true;
                        break;
                    }
                }

                if (!canReachP) {
                    for (int k = 1; k < i; k++) {
                        if (!win[i - k][j]) {
                            canReachP = true;
                            break;
                        }
                    }
                }

                if (!canReachP) {
                    int maxDiag = Math.min(i, j);
                    for (int k = 1; k < maxDiag; k++) {
                        if (!win[i - k][j - k]) {
                            canReachP = true;
                            break;
                        }
                    }
                }

                win[i][j] = canReachP;
            }
        }

        return win[m][n] ? 1 : 2;
    }
}