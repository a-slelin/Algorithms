package a.slelin.work.algorithms.acmp.task0465;

import java.io.*;
import java.math.BigInteger;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            writer.print(solve(n));
        }

        reader.close();
        writer.close();
    }

    public static BigInteger solve(int n) {
        if (n == 1) return BigInteger.valueOf(2);
        if (n == 2) return BigInteger.valueOf(3);

        BigInteger a = BigInteger.valueOf(2);
        BigInteger b = BigInteger.valueOf(3);
        BigInteger c;

        for (int i = 3; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return b;
    }
}