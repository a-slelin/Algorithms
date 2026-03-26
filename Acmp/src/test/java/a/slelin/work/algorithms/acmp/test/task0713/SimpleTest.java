package a.slelin.work.algorithms.acmp.test.task0713;

import a.slelin.work.algorithms.acmp.task0713.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        String result = Main.solve(4, new int[]{0, 1, 1, 0});
        assertNotNull(result);
        assertEquals("1101", result);
    }

    @Test
    public void test2() {
        String result = Main.solve(5, new int[]{0, 1, 0, 0});
        assertNotNull(result);
        assertEquals("11111", result);
    }

    @Test
    public void test3() {
        String result = Main.solve(6, new int[]{0, 0, 0, 0});
        assertNotNull(result);
        assertEquals("No solution", result);
    }
}