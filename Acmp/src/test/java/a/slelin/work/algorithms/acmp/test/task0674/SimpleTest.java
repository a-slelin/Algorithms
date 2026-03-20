package a.slelin.work.algorithms.acmp.test.task0674;

import a.slelin.work.algorithms.acmp.task0674.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(3);
        assertEquals(1, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(6);
        assertEquals(2, result);
    }
}
