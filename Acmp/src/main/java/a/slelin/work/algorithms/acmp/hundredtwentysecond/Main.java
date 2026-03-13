package a.slelin.work.algorithms.acmp.hundredtwentysecond;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
    static void main() {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {

            int N = Integer.parseInt(br.readLine().trim());

            int[] serial = Arrays.stream(br.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            long result = solve(N, serial);

            printWriter.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static long solve(int n, int[] serial) {
        int[] tails = new int[serial.length];
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
