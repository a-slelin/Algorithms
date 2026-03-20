package a.slelin.work.algorithms.acmp.task0268;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = reader.readLine();
            if (s != null) {
                writer.print(solve(n, k, s.trim()));
            }
        }

        reader.close();
        writer.close();
    }

    public static long solve(int n, int k, String s) {
        long count = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int mismatches = 0;
            count++;
            for (int d = 1; i - d >= 0 && i + d < n; d++) {
                if (chars[i - d] != chars[i + d]) {
                    mismatches++;
                }
                if (mismatches <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int mismatches = 0;
            for (int d = 0; i - d >= 0 && i + 1 + d < n; d++) {
                if (chars[i - d] != chars[i + 1 + d]) {
                    mismatches++;
                }
                if (mismatches <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}