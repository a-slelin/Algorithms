package a.slelin.work.algorithms.acmp.task0379;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            StringTokenizer st = new StringTokenizer(line);
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            writer.print(solve(day, month));
        }

        reader.close();
        writer.close();
    }

    public static int solve(int dStart, int mStart) {
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean[][] win = new boolean[32][13];

        for (int m = 12; m >= 1; m--) {
            for (int d = days[m]; d >= 1; d--) {
                if (d == 31 && m == 12) continue;

                boolean canMoveToL = false;

                for (int s = 1; s <= 2; s++) {
                    int nd = d + s;
                    if (nd <= days[m]) {
                        if (!(nd == 31 && m == 12)) {
                            if (!win[nd][m]) {
                                canMoveToL = true;
                                break;
                            }
                        }
                    }
                }

                if (canMoveToL) {
                    win[d][m] = true;
                    continue;
                }

                for (int s = 1; s <= 2; s++) {
                    int nm = m + s;
                    if (nm <= 12 && d <= days[nm]) {
                        if (!(d == 31 && nm == 12)) {
                            if (!win[d][nm]) {
                                canMoveToL = true;
                                break;
                            }
                        }
                    }
                }

                win[d][m] = canMoveToL;
            }
        }

        return win[dStart][mStart] ? 1 : 2;
    }
}