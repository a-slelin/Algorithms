package a.slelin.work.algorithms.acmp.task0680;

import java.io.*;

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

    public static long solve(int n) {
        if (n <= 0) return 0;
        long result = 3;
        for (int i = 1; i < n; i++) {
            result *= 2;
        }
        return result;
    }
}