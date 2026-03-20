package a.slelin.work.algorithms.acmp.test.task0212;

import a.slelin.work.algorithms.acmp.task0212.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(3, 2, new int[][]{
                {1, 2},
                {3, 2}
        });
        assertEquals(1, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(11, 6, new int[][]{
                {1, 2}, {1, 3}, {1, 4}, {1, 5},
                {2, 6}, {2, 7}, {2, 8},
                {4, 9}, {4, 10}, {4, 11}
        });
        assertEquals(2, result);
    }
}
