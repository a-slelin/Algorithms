package a.slelin.work.algorithms.acmp.task0223;

import java.io.*;
import java.math.BigInteger;

public class Main {

    private static BigInteger[][][] memo;

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();

        if (s1 == null || s2 == null) return;

        BigInteger result = solve(s1.trim(), s2.trim());

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.print(result);
        writer.close();
    }

    public static BigInteger solve(String s1, String s2) {
        if (s1.length() != s2.length()) return BigInteger.ZERO;
        int n = s1.length();
        memo = new BigInteger[n + 1][n + 1][n + 1];
        return dp(s1, s2, 0, 0, n);
    }

    private static BigInteger dp(String s1, String s2, int i, int j, int len) {
        if (len == 0) return BigInteger.ONE;
        if (memo[i][j][len] != null) return memo[i][j][len];

        BigInteger count = BigInteger.ZERO;
        for (int k = 0; k < len; k++) {
            if (s1.charAt(i) == s2.charAt(j + k)) {
                BigInteger left = dp(s1, s2, i + 1, j, k);
                if (!left.equals(BigInteger.ZERO)) {
                    BigInteger right = dp(s1, s2, i + k + 1, j + k + 1, len - 1 - k);
                    count = count.add(left.multiply(right));
                }
            }
        }
        return memo[i][j][len] = count;
    }
}