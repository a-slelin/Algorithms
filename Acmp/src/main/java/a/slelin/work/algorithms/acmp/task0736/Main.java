package a.slelin.work.algorithms.acmp.task0736;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        FastReader fr = new FastReader(new FileInputStream("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        String nStr = fr.next();
        if (nStr == null) {
            pw.close();
            return;
        }
        long n = Long.parseLong(nStr);
        long k = fr.nextLong();
        int l = fr.nextInt();

        for (int i = 0; i < l; i++) {
            long queryIndex = fr.nextLong();
            pw.println(solve(n, k, queryIndex));
        }
        pw.close();
    }

    public static long solve(long n, long k, long x) {
        long pos = x;
        long curN = n;
        long totalRemoved = 0;

        while (true) {
            if (curN < k) return 0;

            long qp = pos / k;
            long qn = curN / k;

            if (qp == 0) return 0;

            if (pos % k == 0) {
                return totalRemoved + pos / k;
            }

            long r0 = pos % k;
            long m2 = (curN - qn * k) / qn + 1;
            if (r0 % qp == 0) {
                long r = r0 / qp;
                if (r < m2) {
                    return totalRemoved + r * qn + (pos - r * qp) / k;
                }
            }


            long m1 = r0 / qp + 1;
            long m = Math.min(m1, m2);

            pos -= m * qp;
            curN -= m * qn;
            totalRemoved += m * qn;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
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

        public int nextInt() {
            String next = next();
            return next == null ? -1 : Integer.parseInt(next);
        }

        public long nextLong() {
            String next = next();
            return next == null ? -1 : Long.parseLong(next);
        }
    }
}