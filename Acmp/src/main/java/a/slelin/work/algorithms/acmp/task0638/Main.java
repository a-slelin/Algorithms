package a.slelin.work.algorithms.acmp.task0638;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            String s = next();
            return s == null ? -1 : Integer.parseInt(s);
        }
    }

    static void main() throws IOException {
        FastReader fr = new FastReader(new FileInputStream("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        int n = fr.nextInt();
        int k = fr.nextInt();
        if (n == -1) {
            writer.close();
            return;
        }

        int w = fr.nextInt();
        int dwCount = fr.nextInt();
        int s = fr.nextInt();

        boolean[] badWeekdays = new boolean[w + 1];
        for (int i = 0; i < dwCount; i++) {
            int day = fr.nextInt();
            if (day != -1) badWeekdays[day] = true;
        }

        int dmCount = fr.nextInt();
        boolean[] badDates = new boolean[n + 1];
        for (int i = 0; i < dmCount; i++) {
            int date = fr.nextInt();
            if (date != -1) badDates[date] = true;
        }

        writer.print(solve(n, k, w, s, badWeekdays, badDates));
        writer.close();
    }

    public static int solve(int n, int k, int w, int s, boolean[] badWeekdays, boolean[] badDates) {
        int totalWays = 0;
        int currentConsecutiveGood = 0;

        for (int i = 1; i <= n; i++) {
            int weekday = ((s - 1) + (i - 1)) % w + 1;
            boolean isForbidden = badWeekdays[weekday] || badDates[i];

            if (!isForbidden) {
                currentConsecutiveGood++;
            } else {
                if (currentConsecutiveGood >= k) {
                    totalWays += (currentConsecutiveGood - k + 1);
                }
                currentConsecutiveGood = 0;
            }
        }

        if (currentConsecutiveGood >= k) {
            totalWays += (currentConsecutiveGood - k + 1);
        }

        return totalWays;
    }
}