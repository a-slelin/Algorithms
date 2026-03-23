package a.slelin.work.algorithms.acmp.test.task0502;

import a.slelin.work.algorithms.acmp.task0502.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(3, new int[][]{
                {8, 2, 1},
                {1, 2, 6},
                {2, 7, 2}
        });
        assertEquals(14, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(5, new int[][]{
                {8, 2, 1, 2, 3},
                {1, 2, 6, 2, 4},
                {2, 7, 2, 3, 4},
                {1, 3, 2, 4, 4},
                {1, 3, 4, 3, 1}
        });
        assertEquals(19, result);
    }
}
