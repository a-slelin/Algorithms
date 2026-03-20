package a.slelin.work.algorithms.acmp.task0186;

import java.io.*;
import java.util.Arrays;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        int n = Integer.parseInt(reader.readLine().trim());
        int[] a = new int[n];

        int count = 0;
        while (count < n) {
            String line = reader.readLine();
            if (line == null) break;
            String[] parts = line.trim().split("\\s+");
            for (String s : parts) {
                if (!s.isEmpty()) a[count++] = Integer.parseInt(s);
            }
        }

        int result = solve(n, a);

        writer.println(result);
        writer.close();
        reader.close();
    }

    public static int solve(int n, int[] a) {
        Arrays.sort(a);
        if (n == 2) return a[1] - a[0];
        if (n == 3) return a[2] - a[0];

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 2000000000;
        dp[2] = a[1] - a[0];
        dp[3] = a[2] - a[0];

        for (int i = 4; i <= n; i++) {
            int opt1 = Math.max(dp[i - 2], a[i - 1] - a[i - 2]);
            int opt2 = Math.max(dp[i - 3], a[i - 1] - a[i - 3]);
            dp[i] = Math.min(opt1, opt2);
        }

        return dp[n];
    }
}