package a.slelin.work.algorithms.leetcode.test.task0001;

import a.slelin.work.algorithms.leetcode.task0001.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

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
