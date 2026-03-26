package a.slelin.work.algorithms.acmp.test.task0728;

import a.slelin.work.algorithms.acmp.task0728.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(9, 2, new int[][]{
                {1, 1},
                {10, 8}
        });
        assertEquals(8, result);
    }
}