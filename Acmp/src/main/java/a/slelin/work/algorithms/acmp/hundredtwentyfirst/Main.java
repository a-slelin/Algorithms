package a.slelin.work.algorithms.acmp.hundredtwentyfirst;

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

            int[] coords = Arrays.stream(br.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            long result = solve(N, coords);

            printWriter.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static long solve(int n, int[] coords) {
        Arrays.sort(coords);

        long prev0 = 0;
        long prev1 = Long.MAX_VALUE / 2;

        for (int i = 0; i < n - 1; i++) {
            long w = coords[i + 1] - coords[i];
            long new0 = prev1;
            long new1 = Math.min(prev1, prev0) + w;
            prev0 = new0;
            prev1 = new1;
        }
        return prev1;
    }
}
