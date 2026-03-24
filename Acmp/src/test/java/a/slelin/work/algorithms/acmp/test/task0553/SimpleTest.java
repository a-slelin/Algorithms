package a.slelin.work.algorithms.acmp.test.task0553;

import a.slelin.work.algorithms.acmp.task0553.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int n = 3;
        int[] m = {0, 34, 29, 4};
        int[] k = {0, 29, 4, 15};
        long result = Main.solve(n, m, k);
        assertEquals(646, result);
    }
}