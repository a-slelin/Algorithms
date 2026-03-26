package a.slelin.work.algorithms.acmp.task0470;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[][] cachedPref;
    private static int[][] cachedGrid;

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"))));

        String line = reader.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < w; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = null;
        for (int i = 0; i < n; i++) {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(reader.readLine());
            }
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            writer.println(solve(grid, r1, c1, r2, c2));
        }

        reader.close();
        writer.close();
    }

    public static int solve(int[][] grid, int r1, int c1, int r2, int c2) {
        if (grid != cachedGrid) {
            cachedGrid = grid;
            int h = grid.length;
            int w = grid[0].length;
            cachedPref = new int[h + 1][w + 1];
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    cachedPref[i][j] = grid[i - 1][j - 1]
                            + cachedPref[i - 1][j]
                            + cachedPref[i][j - 1]
                            - cachedPref[i - 1][j - 1];
                }
            }
        }
        return cachedPref[r2][c2] - cachedPref[r1 - 1][c2] - cachedPref[r2][c1 - 1] + cachedPref[r1 - 1][c1 - 1];
    }
}