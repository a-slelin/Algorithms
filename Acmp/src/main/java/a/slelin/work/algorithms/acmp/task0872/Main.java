package a.slelin.work.algorithms.acmp.task0872;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int m = Integer.parseInt(line.trim());
            String[] s = new String[m];
            for (int i = 0; i < m; i++) {
                String word = reader.readLine();
                s[i] = (word == null) ? "" : word.trim();
            }
            writer.print(solve(m, s));
        }

        reader.close();
        writer.close();
    }

    public static int solve(int m, String[] s) {
        if (m <= 0) return 0;

        Arrays.sort(s, Comparator.comparingInt(String::length));

        int[] dp = new int[m];
        int maxLen = 0;

        for (int i = 0; i < m; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (s[i].length() > s[j].length() && s[i].startsWith(s[j])) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }

        return maxLen;
    }
}