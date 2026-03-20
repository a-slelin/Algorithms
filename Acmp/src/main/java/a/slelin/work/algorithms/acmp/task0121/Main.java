package a.slelin.work.algorithms.acmp.task0121;

import java.io.*;
import java.util.Arrays;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        int N = Integer.parseInt(reader.readLine().trim());

        int[] coords = Arrays.stream(reader.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long result = solve(N, coords);

        writer.println(result);
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
