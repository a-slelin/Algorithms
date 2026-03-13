package a.slelin.work.algorithms.acmp.test.hundredsixtyfifth;

import a.slelin.work.algorithms.acmp.hundredsixtyfifth.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

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
