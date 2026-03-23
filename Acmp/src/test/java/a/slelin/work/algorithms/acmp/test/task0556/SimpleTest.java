package a.slelin.work.algorithms.acmp.test.task0556;

import a.slelin.work.algorithms.acmp.task0556.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        double result = Main.solve(3, new double[]{1, 0.1, 0.9});
        assertEquals(0.18, result);
    }
}
