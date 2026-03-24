package a.slelin.work.algorithms.tbank.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void main() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine().trim());

            StringTokenizer st = new StringTokenizer(reader.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] result = solve(n, a);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(result[i]).append(i == n - 1 ? "" : " ");
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] solve(int n, int[] a) {
        int maxVal = 0;
        for (int x : a) {
            if (x > maxVal) maxVal = x;
        }

        int[] count = new int[maxVal + 1];
        boolean[] isExtremum = new boolean[maxVal + 1];

        for (int x : a) {
            count[x]++;
        }

        for (int i = 0; i < n; i++) {
            int prev = a[(i - 1 + n) % n];
            int curr = a[i];
            int next = a[(i + 1) % n];

            if ((curr >= prev && curr >= next) || (curr <= prev && curr <= next)) {
                isExtremum[curr] = true;
            }
        }

        int[] answers = new int[n];
        for (int i = 0; i < n; i++) {
            int val = a[i];
            int baseSteps = n - count[val];
            answers[i] = isExtremum[val] ? baseSteps : baseSteps + 1;
        }

        return answers;
    }
}