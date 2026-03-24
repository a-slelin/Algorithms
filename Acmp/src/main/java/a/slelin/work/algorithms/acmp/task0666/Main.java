package a.slelin.work.algorithms.acmp.task0666;

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

    public static char solve(int n) {
        int k = 26;
        while (n > 1) {
            int h = 1 << (k - 1);
            if (n > h) {
                n -= h;
            } else {
                n -= 1;
            }
            k--;
        }
        return (char) ('a' + k - 1);
    }
}