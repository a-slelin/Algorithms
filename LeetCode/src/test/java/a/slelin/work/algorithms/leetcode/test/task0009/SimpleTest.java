package a.slelin.work.algorithms.leetcode.test.task0009;

import a.slelin.work.algorithms.leetcode.task0009.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTest {

    @Test
    public void test1() {
        Solution solution = new Solution();
        int digit = 121;

        boolean palindrome = solution.isPalindrome(digit);
        assertTrue(palindrome);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int digit = -121;

        boolean palindrome = solution.isPalindrome(digit);
        assertFalse(palindrome);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int digit = 10;

        boolean palindrome = solution.isPalindrome(digit);
        assertFalse(palindrome);
    }
}
