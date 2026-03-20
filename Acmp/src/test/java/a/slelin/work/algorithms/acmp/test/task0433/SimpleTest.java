package a.slelin.work.algorithms.acmp.test.task0433;

import a.slelin.work.algorithms.acmp.task0433.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(3, "bab");
        assertEquals(2, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(8, "abbababa");
        assertEquals(13, result);
    }
}
