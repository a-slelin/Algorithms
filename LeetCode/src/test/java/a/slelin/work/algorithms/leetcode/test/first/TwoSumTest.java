package a.slelin.work.algorithms.leetcode.test.first;

import a.slelin.work.algorithms.leetcode.first.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int[] nums = {3, 3};
        int target = 6;

        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }
}
