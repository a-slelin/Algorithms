package a.slelin.work.algorithms.acmp.test.task0480;

import a.slelin.work.algorithms.acmp.task0480.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(3, new int[]{4, 9, 1}, 3);
        assertEquals(14, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(4, new int[]{1, 2, 2, 7}, 3);
        assertEquals(5, result);
    }

    @Test
    public void test3() {
        int result = Main.solve(5, new int[]{3, 4, 8, 1, 7}, 2);
        assertEquals(18, result);
    }
}