package a.slelin.work.algorithms.acmp.test.task0307;

import a.slelin.work.algorithms.acmp.task0307.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int[][] perfs = {{3, 1}, {1, 2}, {1, 3}, {3, 2}};
        long result = Main.solve(3, 3, 4, perfs);
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        int[][] perfs = {{1, 1}, {2, 2}};
        long result = Main.solve(2, 2, 2, perfs);
        assertEquals(0, result);
    }
}
