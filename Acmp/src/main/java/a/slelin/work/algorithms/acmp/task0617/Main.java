package a.slelin.work.algorithms.acmp.task0617;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        if (line == null) {
            reader.close();
            return;
        }

        StringTokenizer st = new StringTokenizer(line);
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        reader.close();

        BigInteger result = solve(m, n, w, b);

        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
        writer.print(result.toString());
        writer.close();
    }

    public static BigInteger solve(int m, int n, int w, int b) {
        int maxNCR = Math.max(m * n, 100);
        BigInteger[][] nCr = new BigInteger[maxNCR + 1][maxNCR + 1];
        for (int i = 0; i <= maxNCR; i++) {
            nCr[i][0] = BigInteger.ONE;
            for (int j = 1; j <= i; j++) {
                nCr[i][j] = nCr[i - 1][j - 1].add(nCr[i - 1][j]);
            }
            for (int j = i + 1; j <= maxNCR; j++) {
                nCr[i][j] = BigInteger.ZERO;
            }
        }

        BigInteger totalWays = BigInteger.ZERO;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                BigInteger waysW = BigInteger.ZERO;
                for (int p = 0; p <= i; p++) {
                    for (int q = 0; q <= j; q++) {
                        int cells = (i - p) * (j - q);
                        BigInteger term = nCr[i][p].multiply(nCr[j][q]);
                        if (cells >= 0 && w <= cells) {
                            term = term.multiply(nCr[cells][w]);
                        } else {
                            term = BigInteger.ZERO;
                        }

                        if ((p + q) % 2 == 1) {
                            waysW = waysW.subtract(term);
                        } else {
                            waysW = waysW.add(term);
                        }
                    }
                }

                if (waysW.equals(BigInteger.ZERO)) continue;

                BigInteger rowComb = nCr[m][i];
                BigInteger colComb = nCr[n][j];

                int remainingCells = (m - i) * (n - j);
                BigInteger waysB = BigInteger.ZERO;
                if (remainingCells >= 0 && b <= remainingCells) {
                    waysB = nCr[remainingCells][b];
                }

                if (waysB.equals(BigInteger.ZERO)) continue;

                BigInteger currentCase = waysW.multiply(rowComb).multiply(colComb).multiply(waysB);
                totalWays = totalWays.add(currentCase);
            }
        }

        return totalWays;
    }
}