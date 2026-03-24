package a.slelin.work.algorithms.tbank.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static void main() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String s = reader.readLine().trim();

            String result = solve(s);

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String solve(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        int pos = 0;
        while (pos < n && chars[pos] == '0') {
            pos++;
        }

        chars[0] = chars[pos];
        chars[pos] = '0';

        return String.valueOf(chars);
    }
}
