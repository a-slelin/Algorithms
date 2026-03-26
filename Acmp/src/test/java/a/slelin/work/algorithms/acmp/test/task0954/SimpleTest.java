package a.slelin.work.algorithms.acmp.test.task0954;

import a.slelin.work.algorithms.acmp.task0954.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(11);
        assertEquals(2, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(22);
        assertEquals(6, result);
    }

    @Test
    public void test3() {
        int result = Main.solve(32);
        assertEquals(12, result);
    }
}
