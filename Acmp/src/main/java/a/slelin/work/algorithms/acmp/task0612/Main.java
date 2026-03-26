package a.slelin.work.algorithms.acmp.task0612;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String xStr = reader.readLine();
        String yStr = reader.readLine();

        if (xStr == null) {
            reader.close();
            return;
        }
        if (yStr == null) yStr = "";

        String result = solve(xStr, yStr);

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.println(result);
        writer.close();
        reader.close();
    }

    public static String solve(String X, String Y) {
        String x = reduce(X);
        String y = reduce(Y);

        int nx = x.length();
        int ny = y.length();

        short[][] dp = new short[nx + 1][ny + 1];
        int maxLen = 0;
        int endX = 0;
        int endY = 0;

        for (int i = 1; i <= nx; i++) {
            char cx = x.charAt(i - 1);
            for (int j = 1; j <= ny; j++) {
                if (cx == y.charAt(j - 1)) {
                    dp[i][j] = (short) (dp[i - 1][j - 1] + 1);
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endX = i;
                        endY = j;
                    }
                }
            }
        }

        String p = x.substring(0, endX - maxLen);
        String s = x.substring(endX);
        String k = y.substring(0, endY - maxLen);
        String l = y.substring(endY);

        return p +
                getInverse(k) +
                Y +
                getInverse(l) +
                s;
    }

    private static boolean isInverse(char c1, char c2) {
        return Math.abs(c1 - c2) == 32;
    }

    private static String reduce(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!sb.isEmpty() && isInverse(sb.charAt(sb.length() - 1), c)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static char invertChar(char c) {
        if (c >= 'a' && c <= 'z') return (char) (c - 32);
        return (char) (c + 32);
    }

    private static String getInverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(invertChar(s.charAt(i)));
        }
        return sb.toString();
    }
}