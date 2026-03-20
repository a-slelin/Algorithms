package a.slelin.work.algorithms.acmp.task0473;

import java.io.*;
import java.math.BigInteger;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            int n = Integer.parseInt(line.trim());
            BigInteger result = solve(n);
            writer.print(result);
        }

        reader.close();
        writer.close();
    }

    public static BigInteger solve(int n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            BigInteger next = a.add(b);
            a = b;
            b = next;
        }
        return b.multiply(b);
    }
}