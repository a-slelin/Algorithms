package a.slelin.work.algorithms.tbank.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void main() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String s = reader.readLine().trim();

            int result = solve(s);

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int solve(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        char[] target1 = "tbank".toCharArray();
        char[] target2 = "study".toCharArray();

        int m = n - 4;
        int[] costTarget1 = new int[m];
        int[] costTarget2 = new int[m];
        for (int i = 0; i + 5 <= n; ++i) {
            int c1 = 0, c2 = 0;
            for (int j = 0; j < 5; ++j) {
                if (chars[i + j] != target1[j]) {
                    c1++;
                }

                if (chars[i + j] != target2[j]) {
                    c2++;
                }
            }

            costTarget1[i] = c1;
            costTarget2[i] = c2;
        }

        int answer = Integer.MAX_VALUE;

        int[] prefMin = new int[m];
        prefMin[0] = costTarget1[0];
        for (int i = 1; i < m; ++i) {
            prefMin[i] = Math.min(prefMin[i - 1], costTarget1[i]);
        }

        int[] sufMin = new int[m];
        sufMin[m - 1] = costTarget1[m - 1];
        for (int i = m - 2; i >= 0; --i) {
            sufMin[i] = Math.min(sufMin[i + 1], costTarget1[i]);
        }

        for (int i = 0; i < m; ++i) {

            if (i - 5 >= 0) {
                answer = Math.min(answer, prefMin[i - 5] + costTarget2[i]);
            }

            if (i + 5 < m) {
                answer = Math.min(answer, costTarget2[i] + sufMin[i + 5]);
            }
        }

        return answer;
    }
}
