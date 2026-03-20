package a.slelin.work.algorithms.acmp.task0305;

import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return -1;
            st = new StringTokenizer(line);
        }
        return Integer.parseInt(st.nextToken());
    }

    static void main() throws IOException {
        br = new BufferedReader(new FileReader("input.txt"));
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();

        if (n == -1) {
            br.close();
            return;
        }

        int[][] ships = new int[k][4];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 4; j++) {
                ships[i][j] = nextInt();
            }
        }
        br.close();

        int result = solve(n, m, ships);

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.print(result);
        writer.close();
    }

    public static int solve(int n, int m, int[][] ships) {
        boolean[][] forbidden = new boolean[n + 1][m + 1];
        for (int[] ship : ships) {
            int r1 = ship[0];
            int c1 = ship[1];
            int r2 = ship[2];
            int c2 = ship[3];

            for (int r = r1 - 1; r <= r2 + 1; r++) {
                for (int c = c1 - 1; c <= c2 + 1; c++) {
                    if (r >= 1 && r <= n && c >= 1 && c <= m) {
                        forbidden[r][c] = true;
                    }
                }
            }
        }

        int[] h = new int[m + 2];
        int maxArea = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (forbidden[i][j]) {
                    h[j] = 0;
                } else {
                    h[j]++;
                }
            }
            maxArea = Math.max(maxArea, getMaxArea(h, m));
        }
        return maxArea;
    }

    private static int getMaxArea(int[] h, int m) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= m + 1; i++) {
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i - 1 : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}