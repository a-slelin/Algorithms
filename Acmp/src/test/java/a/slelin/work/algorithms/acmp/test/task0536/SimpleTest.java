package a.slelin.work.algorithms.acmp.test.task0536;

import a.slelin.work.algorithms.acmp.task0536.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(3, 11, 2, "111");
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(19, 9, 1, "0123456789876543210");
        assertEquals(1, result);
    }

    @Test
    public void test3() {
        long result = Main.solve(1, 8, 3, "9");
        assertEquals(0, result);
    }
}