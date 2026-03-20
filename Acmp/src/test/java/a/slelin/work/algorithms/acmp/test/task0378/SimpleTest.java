package a.slelin.work.algorithms.acmp.test.task0378;

import a.slelin.work.algorithms.acmp.task0378.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(3, new int[]{1, 1, 2});
        assertEquals(5, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(3, new int[]{1, 3, 2});
        assertEquals(7, result);
    }

    @Test
    public void test3() {
        int result = Main.solve(5, new int[]{49, 100, 98, 49, 0});
        assertEquals(10, result);
    }
}
