package a.slelin.work.algorithms.acmp.test.task0646;

import a.slelin.work.algorithms.acmp.task0646.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(4, 3, new long[]{1, 2, 3, 2});
        assertEquals(8, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(5, 67, new long[]{10, 22, 30, 41, 50});
        assertEquals(6, result);
    }

    @Test
    public void test3() {
        long result = Main.solve(3, 6, new long[]{4, 1, 5});
        assertEquals(0, result);
    }
}