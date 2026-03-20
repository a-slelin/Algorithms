package a.slelin.work.algorithms.acmp.task0433;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            String s = reader.readLine();
            if (s != null) {
                writer.print(solve(n, s.trim()));
            }
        }

        reader.close();
        writer.close();
    }

    public static long solve(int n, String s) {
        int[] freq = new int[2 * n + 1];
        int cur = 0;
        long res = 0;
        freq[n] = 1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                cur--;
            } else {
                cur++;
            }
            res += freq[cur + n];
            freq[cur + n]++;
        }

        return res;
    }
}