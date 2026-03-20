package a.slelin.work.algorithms.acmp.test.task0908;

import a.slelin.work.algorithms.acmp.task0908.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(5);
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(1);
        assertEquals(0, result);
    }

    @Test
    public void test3() {
        int result = Main.solve(10);
        assertEquals(3, result);
    }
}
