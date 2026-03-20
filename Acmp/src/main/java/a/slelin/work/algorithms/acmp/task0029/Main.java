package a.slelin.work.algorithms.acmp.task0029;

import java.io.*;
import java.util.Arrays;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        @SuppressWarnings("unused")
        int n = Integer.parseInt(reader.readLine().trim());

        int[] platforms = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        long result = solve(platforms);

        writer.println(result);
    }

    public static long solve(int[] platforms) {
        int n = platforms.length;
        long[] array = new long[n];
        Arrays.fill(array, Long.MAX_VALUE);
        array[0] = 0L;

        for (int i = 0; i < n - 1; i++) {
            array[i + 1] = Math.min(array[i] + Math.abs(platforms[i + 1] - platforms[i]), array[i + 1]);

            if (i != n - 2)
                array[i + 2] = Math.min(array[i] + 3L * Math.abs(platforms[i + 2] - platforms[i]), array[i + 2]);
        }

        return array[n - 1];
    }
}
