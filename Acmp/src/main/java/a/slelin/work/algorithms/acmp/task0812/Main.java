package a.slelin.work.algorithms.acmp.task0812;

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
                int a = Integer.parseInt(st.nextToken());

                writer.print(solve(n, a));
            }
        }

        reader.close();
        writer.close();
    }

    public static BigInteger solve(int n, int a) {
        if (n == 0) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;

        BigInteger currentSum = BigInteger.ZERO;

        for (int i = 1; i <= n; i++) {
            currentSum = currentSum.add(dp[i - 1]);

            if (i > a) {
                currentSum = currentSum.subtract(dp[i - a - 1]);
            }

            dp[i] = currentSum;
        }

        return dp[n];
    }
}