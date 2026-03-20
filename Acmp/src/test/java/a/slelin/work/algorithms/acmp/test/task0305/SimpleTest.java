package a.slelin.work.algorithms.acmp.test.task0305;

import a.slelin.work.algorithms.acmp.task0305.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(8, 7, new int[][]{
                {1, 1, 2, 2},
                {3, 5, 3, 7},
                {4, 2, 4, 3}
        });
        assertEquals(21, result);
    }
}
