package a.slelin.work.algorithms.acmp.task0329;

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
                String nextLine = reader.readLine();
                if (nextLine == null) break;
                StringTokenizer st = new StringTokenizer(nextLine);
                while (st.hasMoreTokens()) {
                    a[count++] = Integer.parseInt(st.nextToken());
                }
            }

            long[] result = solve(n, a);

            writer.println(result[0]);
            for (int i = 1; i < result.length; i++) {
                writer.print(result[i] + (i == result.length - 1 ? "" : " "));
            }
        }

        reader.close();
        writer.close();
    }

    public static long[] solve(int n, int[] a) {
        int[] dp = new int[n];
        int[] parent = new int[n];

        dp[0] = a[0];
        parent[0] = -1;

        if (n > 1) {
            if (dp[0] > 0) {
                dp[1] = dp[0] + a[1];
                parent[1] = 0;
            } else {
                dp[1] = a[1];
                parent[1] = -1;
            }
        }

        for (int i = 2; i < n; i++) {
            if (dp[i - 1] > dp[i - 2]) {
                dp[i] = dp[i - 1] + a[i];
                parent[i] = i - 1;
            } else {
                dp[i] = dp[i - 2] + a[i];
                parent[i] = i - 2;
            }
        }

        List<Integer> path = new ArrayList<>();
        int curr = n - 1;
        while (curr != -1) {
            path.add(curr + 1);
            curr = parent[curr];
        }
        Collections.reverse(path);

        long[] res = new long[path.size() + 1];
        res[0] = dp[n - 1];
        for (int i = 0; i < path.size(); i++) {
            res[i + 1] = path.get(i);
        }
        return res;
    }
}