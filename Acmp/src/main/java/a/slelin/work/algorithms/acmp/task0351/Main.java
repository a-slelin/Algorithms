package a.slelin.work.algorithms.acmp.task0351;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            char[] s = new char[n];
            int readCount = 0;
            int charRead;
            while (readCount < n && (charRead = reader.read()) != -1) {
                if (charRead >= 'A' && charRead <= 'Z') {
                    s[readCount++] = (char) charRead;
                }
            }

            int result = solve(n, k, s);
            writer.print(result);
        }

        reader.close();
        writer.close();
    }

    public static int solve(int n, int k, char[] s) {
        int[] dp = new int[n];

        int[] gNext = new int[n];
        int[] gPrev = new int[n];
        Arrays.fill(gNext, -1);
        Arrays.fill(gPrev, -1);
        int gHead, gTail;

        int[] cNext = new int[n];
        int[] cPrev = new int[n];
        Arrays.fill(cNext, -1);
        Arrays.fill(cPrev, -1);
        int[] cHead = new int[26];
        int[] cTail = new int[26];
        Arrays.fill(cHead, -1);
        Arrays.fill(cTail, -1);

        dp[0] = 0;

        gHead = 0;
        gTail = 0;
        int ci0 = s[0] - 'A';
        cHead[ci0] = 0;
        cTail[ci0] = 0;

        for (int i = 1; i < n; i++) {
            if (i > k) {
                int outIdx = i - k - 1;
                if (gHead == outIdx) {
                    gHead = gNext[outIdx];
                    if (gHead != -1) gPrev[gHead] = -1;
                    else gTail = -1;
                }

                int co = s[outIdx] - 'A';
                if (cHead[co] == outIdx) {
                    cHead[co] = cNext[outIdx];
                    if (cHead[co] != -1) cPrev[cHead[co]] = -1;
                    else cTail[co] = -1;
                }
            }

            int v1 = dp[gHead] + 1;
            int ci = s[i] - 'A';
            int v2 = (cHead[ci] == -1) ? 200000 : dp[cHead[ci]];
            dp[i] = Math.min(v1, v2);

            while (gTail != -1 && dp[gTail] >= dp[i]) {
                int oldTail = gTail;
                gTail = gPrev[oldTail];
                if (gTail != -1) gNext[gTail] = -1;
                else gHead = -1;
            }
            if (gTail == -1) {
                gHead = i;
                gTail = i;
                gPrev[i] = -1;
            } else {
                gNext[gTail] = i;
                gPrev[i] = gTail;
                gTail = i;
            }
            gNext[i] = -1;

            while (cTail[ci] != -1 && dp[cTail[ci]] >= dp[i]) {
                int oldTail = cTail[ci];
                cTail[ci] = cPrev[oldTail];
                if (cTail[ci] != -1) cNext[cTail[ci]] = -1;
                else cHead[ci] = -1;
            }
            if (cTail[ci] == -1) {
                cHead[ci] = i;
                cTail[ci] = i;
                cPrev[i] = -1;
            } else {
                cNext[cTail[ci]] = i;
                cPrev[i] = cTail[ci];
                cTail[ci] = i;
            }
            cNext[i] = -1;
        }

        return dp[n - 1];
    }
}