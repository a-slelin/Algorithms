package a.slelin.work.algorithms.acmp.test.task0083;

import a.slelin.work.algorithms.acmp.task0083.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(2, 2);
        assertEquals(14, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(3, 3);
        assertEquals(322, result);
    }
}
