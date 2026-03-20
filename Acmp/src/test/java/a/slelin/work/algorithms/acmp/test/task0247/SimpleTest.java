package a.slelin.work.algorithms.acmp.test.task0247;

import a.slelin.work.algorithms.acmp.task0247.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

    @Test
    public void test1() {
        int[] result = Main.solve(5, new int[]{35, 40, 101, 59, 63});
        assertNotNull(result);
        assertArrayEquals(new int[]{235, 0, 1}, result);
    }
}
