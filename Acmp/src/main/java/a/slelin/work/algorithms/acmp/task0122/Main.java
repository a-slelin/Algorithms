package a.slelin.work.algorithms.acmp.task0122;

import java.io.*;
import java.util.Arrays;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        int N = Integer.parseInt(reader.readLine().trim());

        int[] serial = Arrays.stream(reader.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long result = solve(N, serial);

        writer.println(result);
    }

    public static long solve(int n, int[] serial) {
        int[] tails = new int[n];
        int size = 0;
        for (int x : serial) {
            int i = Arrays.binarySearch(tails, 0, size, x);
            if (i < 0) i = -(i + 1);
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }
}
