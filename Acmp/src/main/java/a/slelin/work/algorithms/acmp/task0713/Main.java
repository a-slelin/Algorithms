package a.slelin.work.algorithms.acmp.task0713;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        FastReader fr = new FastReader();
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String sN = fr.next();
        if (sN == null) {
            writer.close();
            fr.close();
            return;
        }
        int n = Integer.parseInt(sN);

        int[] fValues = new int[4];
        int idx = 0;
        while (idx < 4) {
            String token = fr.next();
            if (token == null) break;
            for (char c : token.toCharArray()) {
                if (c == '0' || c == '1') {
                    fValues[idx++] = c - '0';
                }
                if (idx == 4) break;
            }
        }

        String result = solve(n, fValues);
        writer.print(result);
        writer.flush();
        writer.close();
        fr.close();
    }

    public static String solve(int n, int[] fValues) {
        int[][] f = new int[2][2];
        f[0][0] = fValues[0];
        f[0][1] = fValues[1];
        f[1][0] = fValues[2];
        f[1][1] = fValues[3];

        int[][] dp = new int[n + 1][2];
        byte[][] parent = new byte[n + 1][2];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int prevS = 0; prevS < 2; prevS++) {
                if (dp[i - 1][prevS] == -1) continue;

                for (int currA = 0; currA < 2; currA++) {
                    int nextS = f[prevS][currA];
                    int newScore = dp[i - 1][prevS] + currA;

                    if (newScore > dp[i][nextS]) {
                        dp[i][nextS] = newScore;
                        parent[i][nextS] = (byte) (prevS | (currA << 1));
                    }
                }
            }
        }

        if (dp[n][1] == -1) {
            return "No solution";
        }

        char[] resChars = new char[n];
        int curS = 1;
        for (int i = n; i >= 2; i--) {
            int pInfo = parent[i][curS];
            int prevS = pInfo & 1;
            int aVal = (pInfo >> 1) & 1;
            resChars[i - 1] = (char) (aVal + '0');
            curS = prevS;
        }
        resChars[0] = (char) (curS + '0');

        return new String(resChars);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("input.txt"));
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

        void close() throws IOException {
            br.close();
        }
    }
}