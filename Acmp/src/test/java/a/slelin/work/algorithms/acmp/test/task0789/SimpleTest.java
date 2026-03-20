package a.slelin.work.algorithms.acmp.test.task0789;

import a.slelin.work.algorithms.acmp.task0789.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(2);
        assertEquals(2, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(9);
        assertEquals(10, result);
    }
}
