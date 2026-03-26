package a.slelin.work.algorithms.acmp.test.task0476;

import a.slelin.work.algorithms.acmp.task0476.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(3, 2);
        assertEquals(2, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(6, 7);
        assertEquals(1, result);
    }
}