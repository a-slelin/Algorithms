package a.slelin.work.algorithms.acmp.task0179;

import java.io.*;
import java.math.BigInteger;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        int k = Integer.parseInt(reader.readLine().trim());

        BigInteger result = solve(k);

        writer.println(result);

        writer.close();
        reader.close();
    }

    public static BigInteger solve(int k) {
        return BigInteger.valueOf(3).pow(k).add(BigInteger.ONE);
    }
}