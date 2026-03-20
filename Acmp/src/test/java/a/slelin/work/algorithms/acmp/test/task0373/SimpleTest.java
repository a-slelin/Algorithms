package a.slelin.work.algorithms.acmp.test.task0373;

import a.slelin.work.algorithms.acmp.task0373.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(5, 7, new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 3, 1, 9},
                {1, 1, 6, 1, 1},
                {1, 1, 3, 1, 1},
                {1, 1, 1, 1, 1}
        });
        assertEquals(21, result);
    }
}
