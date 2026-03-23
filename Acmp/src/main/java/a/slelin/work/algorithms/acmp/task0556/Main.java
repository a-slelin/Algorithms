package a.slelin.work.algorithms.acmp.task0556;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            double[] p = new double[n];
            int count = 0;
            while (count < n) {
                String nextLine = reader.readLine();
                if (nextLine == null) break;
                StringTokenizer st = new StringTokenizer(nextLine);
                while (st.hasMoreTokens()) {
                    p[count++] = Double.parseDouble(st.nextToken());
                }
            }
            double result = solve(n, p);
            writer.printf(Locale.US, "%.6f", result);
        }

        reader.close();
        writer.close();
    }

    public static double solve(int n, double[] p) {
        double pEven = 1.0;

        for (int i = 0; i < n; i++) {
            double pi = p[i];
            double qi = 1.0 - pi;

            pEven = pEven * pi + (1.0 - pEven) * qi;
        }

        return pEven;
    }
}