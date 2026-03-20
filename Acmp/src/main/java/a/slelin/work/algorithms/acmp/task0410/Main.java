package a.slelin.work.algorithms.acmp.task0410;

import java.io.*;
import java.util.*;

public class Main {

    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        String line;
        StringTokenizer st;
        Integer n = null, m = null;

        while ((line = reader.readLine()) != null) {
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                if (n == null) n = Integer.parseInt(st.nextToken());
                else if (m == null) m = Integer.parseInt(st.nextToken());
            }
            if (m != null) break;
        }

        if (n != null && m != null) {
            String result = solve(n, m);
            writer.print(result);
        }

        reader.close();
        writer.close();
    }

    public static String solve(int n, int m) {
        int rTarget = (m - (n % m)) % m;
        if (rTarget == 0) return "0";

        int[] dist = new int[m];
        Arrays.fill(dist, 1000000);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        for (int d = 1; d <= 9; d++) {
            int rem = d % m;
            if (d < dist[rem]) {
                dist[rem] = d;
                pq.add(new long[]{d, rem});
            }
        }

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int s = (int) curr[0];
            int r = (int) curr[1];
            if (s > dist[r]) continue;
            if (r == rTarget) break;
            for (int d = 0; d <= 9; d++) {
                int ns = s + d;
                int nr = (r * 10 + d) % m;
                if (ns < dist[nr]) {
                    dist[nr] = ns;
                    pq.add(new long[]{ns, nr});
                }
            }
        }

        int targetS = dist[rTarget];
        int cols = targetS + 1;
        int[] parentState = new int[m * cols];
        byte[] parentDigit = new byte[m * cols];
        Arrays.fill(parentState, -1);

        int[] queue = new int[m * cols];
        int head = 0, tail = 0;

        for (int d = 1; d <= 9; d++) {
            int r = d % m;
            if (d <= targetS) {
                int state = r * cols + d;
                if (parentState[state] == -1) {
                    parentState[state] = -2;
                    parentDigit[state] = (byte) d;
                    queue[tail++] = state;
                }
            }
        }

        while (head < tail) {
            int currState = queue[head++];
            int r = currState / cols;
            int s = currState % cols;
            if (r == rTarget && s == targetS) break;
            for (int d = 0; d <= 9; d++) {
                int nr = (r * 10 + d) % m;
                int ns = s + d;
                if (ns <= targetS) {
                    int nextState = nr * cols + ns;
                    if (parentState[nextState] == -1) {
                        parentState[nextState] = currState;
                        parentDigit[nextState] = (byte) d;
                        queue[tail++] = nextState;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int curr = rTarget * cols + targetS;
        if (parentState[curr] == -1) return "0";
        while (curr != -2) {
            sb.append(parentDigit[curr]);
            curr = parentState[curr];
        }
        return sb.reverse().toString();
    }
}