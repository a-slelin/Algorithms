package a.slelin.work.algorithms.tbank.test.task5;

import a.slelin.work.algorithms.tbank.task5.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        int[] result = Main.solve(3, new int[]{1, 2, 3});
        assertNotNull(result);
        assertArrayEquals(new int[]{2, 3, 2}, result);
    }

    @Test
    public void test2() {
        int[] result = Main.solve(4, new int[]{1, 2, 1, 3});
        assertNotNull(result);
        assertArrayEquals(new int[]{2, 3, 2, 3}, result);
    }
}
