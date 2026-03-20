package a.slelin.work.algorithms.acmp.test.task0379;

import a.slelin.work.algorithms.acmp.task0379.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(30, 12);
        assertEquals(2, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(29, 12);
        assertEquals(1, result);
    }

    @Test
    public void test3() {
        int result = Main.solve(29, 11);
        assertEquals(2, result);
    }
}
