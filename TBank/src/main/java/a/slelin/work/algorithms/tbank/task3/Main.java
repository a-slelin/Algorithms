package a.slelin.work.algorithms.tbank.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void main() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(reader.readLine().trim());

            long[] results = new long[t];
            for (int i = 0; i < t; i++) {
                String s = reader.readLine().trim();
                results[i] = solve(s);
            }

            for (int i = 0; i < t; i++) {
                System.out.println(results[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long solve(String s) {
        int n = s.length();

        if (!s.contains("0")) {
            return (long) n * n;
        }

        long curr = 0, max = 0;
        for (int i = 0; i < 2 * n; ++i) {
            if (s.charAt(i % n) == '1') {
                curr++;
            } else {
                max = Math.max(max, curr);
                curr = 0;
            }
        }

        long h = (max + 1) / 2;
        long w = max + 1 - h;

        return h * w;
    }
}
