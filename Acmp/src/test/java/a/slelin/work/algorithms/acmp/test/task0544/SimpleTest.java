package a.slelin.work.algorithms.acmp.test.task0544;

import a.slelin.work.algorithms.acmp.task0544.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(1);
        assertEquals(1, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(4);
        assertEquals(7, result);
    }
}
