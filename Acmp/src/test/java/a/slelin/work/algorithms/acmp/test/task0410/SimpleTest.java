package a.slelin.work.algorithms.acmp.test.task0410;

import a.slelin.work.algorithms.acmp.task0410.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        String result = Main.solve(5, 8);
        assertNotNull(result);
        assertEquals("11", result);
    }

    @Test
    public void test2() {
        String result = Main.solve(6, 15);
        assertNotNull(result);
        assertEquals("24", result);
    }
}
