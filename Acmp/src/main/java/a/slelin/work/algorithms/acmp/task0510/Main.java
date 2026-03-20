package a.slelin.work.algorithms.acmp.task0510;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            writer.print(solve(n));
        }

        reader.close();
        writer.close();
    }

    public static long solve(int n) {
        if (n % 2 != 0) return 0;
        if (n == 0) return 1;

        long[] f = new long[n + 1];
        long[] g = new long[n + 1];

        f[0] = 1;
        g[0] = 0;
        f[1] = 0;
        g[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 2] + 2 * g[i - 1];
            g[i] = f[i - 1] + g[i - 2];
        }

        return f[n];
    }
}