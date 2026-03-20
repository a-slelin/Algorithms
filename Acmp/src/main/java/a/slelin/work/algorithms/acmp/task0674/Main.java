package a.slelin.work.algorithms.acmp.task0674;

import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, Long> memo = new HashMap<>();

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
        if (n < 3) return 0;
        if (n == 3) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        long result = solve((n + 1) / 2) + solve(n / 2);
        memo.put(n, result);
        return result;
    }
}