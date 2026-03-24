package a.slelin.work.algorithms.acmp.test.task0356;

import a.slelin.work.algorithms.acmp.task0356.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        String result = Main.solve(1000, 1100, 2, new int[][]{{1, 1}, {5, 2}});
        assertNotNull(result);
        assertEquals("100 250", result);
    }

    @Test
    public void test2() {
        String result = Main.solve(1000, 1010, 2, new int[][]{{6, 3}, {2, 2}});
        assertNotNull(result);
        assertEquals("10 16", result);
    }

    @Test
    public void test3() {
        String result = Main.solve(1000, 2000, 1, new int[][]{{10, 3}});
        assertNotNull(result);
        assertEquals("This is impossible.", result);
    }
}