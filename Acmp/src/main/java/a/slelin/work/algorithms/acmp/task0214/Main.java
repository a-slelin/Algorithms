package a.slelin.work.algorithms.acmp.task0214;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line = reader.readLine();
        if (line != null) {
            String[] parts = line.trim().split("\\s+");
            int n = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);

            writer.print(solve(n, m));
        }

        reader.close();
        writer.close();
    }

    public static int solve(int n, int m) {
        int nimSum = 0;
        if (n % 2 != 0) nimSum ^= 2;
        if (m % 2 != 0) nimSum ^= 3;

        return nimSum == 0 ? 2 : 1;
    }
}