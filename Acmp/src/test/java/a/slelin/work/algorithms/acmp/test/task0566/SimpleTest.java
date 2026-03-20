package a.slelin.work.algorithms.acmp.test.task0566;

import a.slelin.work.algorithms.acmp.task0566.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(2, 2, 2, 4);
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(0, 0, 4, 4);
        assertEquals(2, result);
    }
}
