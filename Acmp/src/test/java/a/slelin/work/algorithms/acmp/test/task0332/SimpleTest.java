package a.slelin.work.algorithms.acmp.test.task0332;

import a.slelin.work.algorithms.acmp.task0332.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(3, new int[][]{
                {0, 7, 10, 20},
                {0, 0, 4, 8},
                {0, 0, 0, 2},
                {0, 0, 0, 0}
        });
        assertEquals(12, result);
    }
}
