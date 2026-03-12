package a.slelin.work.algorithms.leetcode.ninth;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x >= 0) {
            int check = 0, tmp = x;

            while (tmp != 0) {
                int digit = tmp % 10;
                check = check * 10 + digit;
                tmp /= 10;
            }
            return check == x;
        }

        return false;
    }
}