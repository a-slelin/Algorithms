package a.slelin.work.algorithms.acmp.test.task0165;

import a.slelin.work.algorithms.acmp.task0165.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(3, 4, new int[][]{
                {2, 1, 1, 2},
                {3, 2, 1, 44},
                {3, 1, 1, 0}
        });
        assertEquals(3, result);
    }
}
