package a.slelin.work.algorithms.acmp.test.task0214;

import a.slelin.work.algorithms.acmp.task0214.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(2, 2);
        assertEquals(2, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(1, 2);
        assertEquals(1, result);
    }
}
