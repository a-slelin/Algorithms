package a.slelin.work.algorithms.acmp.test.task0115;

import a.slelin.work.algorithms.acmp.task0115.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(2, 3, new int[][]{
                {5, 0, 9},
                {1, 2, 7}
        });
        assertEquals(24, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(4, 5, new int[][]{
                {-7, 8, -1, 0, -2},
                {2, -9, 2, 4, -6},
                {-7, 0, 6, 8, 1},
                {4, -8, -1, 0, -6}
        });
        assertEquals(20, result);
    }
}
