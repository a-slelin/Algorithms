package a.slelin.work.algorithms.acmp.test.task0259;

import a.slelin.work.algorithms.acmp.task0259.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

    @Test
    public void test1() {
        int[] result = Main.solve(5, "aabaa".toCharArray());
        assertNotNull(result);
        assertArrayEquals(new int[]{1, 2, 0, 1, 5}, result);
    }
}
