package a.slelin.work.algorithms.acmp.task0259;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());

        char[] s = new char[n];
        int read = 0;
        while (read < n) {
            int c = reader.read();
            if (c == -1) break;
            if (c == '\r' || c == '\n') {
                if (read == 0) continue;
                else break;
            }
            s[read++] = (char) c;
        }

        int[] result = solve(n, s);

        for (int i = 0; i < n; i++) {
            writer.print(result[i]);
            if (i < n - 1) writer.print(" ");
        }
        writer.println();

        reader.close();
        writer.close();
    }

    public static int[] solve(int n, char[] s) {
        int len = 2 * n + 1;
        char[] t = new char[len];

        for (int i = 0; i < n; i++) {
            t[i] = s[i];
            t[n + 1 + i] = s[n - 1 - i];
        }
        t[n] = '#';

        int[] z = new int[len];
        int l = 0, r = 0;
        for (int i = 1; i < len; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < len && t[z[i]] == t[i + z[i]]) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        int[] a = new int[n];
        for (int i = 1; i <= n; i++) {
            a[i - 1] = z[2 * n + 1 - i];
        }

        return a;
    }
}