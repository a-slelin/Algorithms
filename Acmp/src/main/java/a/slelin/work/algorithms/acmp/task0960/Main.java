package a.slelin.work.algorithms.acmp.task0960;

import java.io.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String s = reader.readLine();
        if (s != null) {
            writer.print(solve(s.trim()));
        } else {
            writer.print(0);
        }

        reader.close();
        writer.close();
    }

    public static long solve(String s) {
        long countA = 0;
        long countAB = 0;
        long countABC = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                countA++;
            } else if (c == 'b') {
                countAB += countA;
            } else if (c == 'c') {
                countABC += countAB;
            }
        }

        return countABC;
    }
}