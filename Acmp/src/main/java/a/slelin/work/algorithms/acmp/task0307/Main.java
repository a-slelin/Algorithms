package a.slelin.work.algorithms.acmp.task0307;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        if (!st.hasMoreTokens()) return;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[][] perfs = new int[p][2];
        for (int i = 0; i < p; i++) {
            line = reader.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);
            perfs[i][0] = Integer.parseInt(st.nextToken());
            perfs[i][1] = Integer.parseInt(st.nextToken());
        }

        long result = solve(n, m, p, perfs);
        System.out.println(result);
    }

    public static long solve(int n, int m, int p, int[][] perfs) {
        int[][] bit = new int[n + 1][m + 1];
        long totalSurprises = 0;

        for (int i = 0; i < p; i++) {
            int a = perfs[i][0];
            int e = perfs[i][1];

            totalSurprises += query(bit, a - 1, m) - query(bit, a - 1, e);

            totalSurprises += query(bit, n, e - 1) - query(bit, a, e - 1);

            update(bit, a, e, n, m);
        }

        return totalSurprises;
    }

    private static void update(int[][] bit, int r, int c, int n, int m) {
        for (int i = r; i <= n; i += i & -i) {
            for (int j = c; j <= m; j += j & -j) {
                bit[i][j] += 1;
            }
        }
    }

    private static int query(int[][] bit, int r, int c) {
        int sum = 0;
        for (int i = r; i > 0; i -= i & -i) {
            for (int j = c; j > 0; j -= j & -j) {
                sum += bit[i][j];
            }
        }
        return sum;
    }
}
