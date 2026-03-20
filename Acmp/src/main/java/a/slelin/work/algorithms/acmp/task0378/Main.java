package a.slelin.work.algorithms.acmp.task0378;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            int[] a = new int[n];
            int count = 0;
            while (count < n) {
                String row = reader.readLine();
                if (row == null) break;
                StringTokenizer st = new StringTokenizer(row);
                while (st.hasMoreTokens()) {
                    a[count++] = Integer.parseInt(st.nextToken());
                }
            }
            writer.print(solve(n, a));
        }

        reader.close();
        writer.close();
    }

    public static int solve(@SuppressWarnings("unused") int n, int[] a) {
        boolean[] dp = new boolean[50001];
        dp[0] = true;
        int currentMax = 0;
        for (int x : a) {
            for (int i = currentMax; i >= 0; i--) {
                if (dp[i]) {
                    dp[i + x] = true;
                }
            }
            currentMax += x;
        }
        int count = 0;
        for (int i = 0; i <= currentMax; i++) {
            if (dp[i]) count++;
        }
        return count;
    }
}