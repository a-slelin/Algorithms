package a.slelin.work.algorithms.acmp.task0518;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            char[][] maze = new char[n][n];
            for (int i = 0; i < n; i++) {
                String row = reader.readLine();
                if (row != null) {
                    maze[i] = row.toCharArray();
                }
            }

            writer.print(solve(n, k, maze));
        }

        reader.close();
        writer.close();
    }

    public static int solve(int n, int k, char[][] maze) {
        int[][][] dp = new int[k + 1][n][n];

        dp[0][0][0] = 1;

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        for (int s = 1; s <= k; s++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (maze[r][c] == '0') {
                        for (int i = 0; i < 4; i++) {
                            int prevR = r + dr[i];
                            int prevC = c + dc[i];

                            if (prevR >= 0 && prevR < n && prevC >= 0 && prevC < n) {
                                if (maze[prevR][prevC] == '0') {
                                    dp[s][r][c] += dp[s - 1][prevR][prevC];
                                }
                            }
                        }
                    }
                }
            }
        }

        return dp[k][n - 1][n - 1];
    }
}