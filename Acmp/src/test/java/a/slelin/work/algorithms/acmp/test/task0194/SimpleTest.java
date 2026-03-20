package a.slelin.work.algorithms.acmp.test.task0194;

import a.slelin.work.algorithms.acmp.task0194.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(4);
        assertEquals(4, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(7);
        assertEquals(14, result);
    }
}
