package a.slelin.work.algorithms.acmp.test.task0329;

import a.slelin.work.algorithms.acmp.task0329.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

    @Test
    public void test1() {
        long[] result = Main.solve(3, new int[]{1, 2, 1});
        assertNotNull(result);
        assertArrayEquals(new long[]{4, 1, 2, 3}, result);
    }

    @Test
    public void test2() {
        long[] result = Main.solve(3, new int[]{1, -1, 1});
        assertNotNull(result);
        assertArrayEquals(new long[]{2, 1, 3}, result);
    }
}
