package a.slelin.work.algorithms.acmp.test.task0121;

import a.slelin.work.algorithms.acmp.task0121.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(6, new int[]{3, 4, 12, 6, 14, 13});
        assertEquals(5, result);
    }
}
