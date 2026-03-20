package a.slelin.work.algorithms.acmp.task0781;

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
        if (n == 0) return 0;
        if (n == 1) return 2;

        long[] f1 = new long[n + 1];
        long[] f2 = new long[n + 1];

        f1[1] = 1;
        f2[1] = 0;

        for (int i = 2; i <= n; i++) {
            f1[i] = f1[i - 1] + f2[i - 1];
            f2[i] = f1[i - 1];
        }

        return 2 * (f1[n] + f2[n]);
    }
}