package a.slelin.work.algorithms.acmp.task0566;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                writer.print(solve(a, b, c, k));
            }
        }

        reader.close();
        writer.close();
    }

    public static int solve(int A, int B, int C, int K) {
        List<int[]> triples = new ArrayList<>();

        for (int da = 0; da <= A; da++) {
            for (int db = 0; db <= B; db++) {
                for (int dc = 0; dc <= C; dc++) {
                    int stars = da + 2 * db + 3 * dc;
                    if (stars < K) continue;

                    if (da > 0 && (stars - 1) >= K) continue;
                    if (db > 0 && (stars - 2) >= K) continue;
                    if (dc > 0 && (stars - 3) >= K) continue;

                    triples.add(new int[]{da, db, dc});
                }
            }
        }

        if (triples.isEmpty()) return 0;

        int[][][] dp = new int[A + 1][B + 1][C + 1];
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        dp[0][0][0] = 0;
        int maxShirts = 0;

        for (int[] t : triples) {
            int da = t[0], db = t[1], dc = t[2];
            for (int i = da; i <= A; i++) {
                for (int j = db; j <= B; j++) {
                    for (int l = dc; l <= C; l++) {
                        if (dp[i - da][j - db][l - dc] != -1) {
                            int newVal = dp[i - da][j - db][l - dc] + 1;
                            if (newVal > dp[i][j][l]) {
                                dp[i][j][l] = newVal;
                                if (newVal > maxShirts) {
                                    maxShirts = newVal;
                                }
                            }
                        }
                    }
                }
            }
        }

        return maxShirts;
    }
}