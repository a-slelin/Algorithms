package a.slelin.work.algorithms.acmp.task0471;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                writer.print(solve(n));
            }
        }

        reader.close();
        writer.close();
    }

    public static BigInteger solve(int n) {
        if (n <= 0) return BigInteger.ZERO;

        BigInteger[][] dp = new BigInteger[n + 1][10];

        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 8) {
                dp[1][i] = BigInteger.ZERO;
            } else {
                dp[1][i] = BigInteger.ONE;
            }
        }


        for (int k = 2; k <= n; k++) {
            dp[k][0] = dp[k - 1][4].add(dp[k - 1][6]);
            dp[k][1] = dp[k - 1][6].add(dp[k - 1][8]);
            dp[k][2] = dp[k - 1][7].add(dp[k - 1][9]);
            dp[k][3] = dp[k - 1][4].add(dp[k - 1][8]);
            dp[k][4] = dp[k - 1][0].add(dp[k - 1][3]).add(dp[k - 1][9]);
            dp[k][5] = BigInteger.ZERO;
            dp[k][6] = dp[k - 1][0].add(dp[k - 1][1]).add(dp[k - 1][7]);
            dp[k][7] = dp[k - 1][2].add(dp[k - 1][6]);
            dp[k][8] = dp[k - 1][1].add(dp[k - 1][3]);
            dp[k][9] = dp[k - 1][2].add(dp[k - 1][4]);
        }

        BigInteger total = BigInteger.ZERO;
        for (int i = 0; i < 10; i++) {
            total = total.add(dp[n][i]);
        }

        return total;
    }
}