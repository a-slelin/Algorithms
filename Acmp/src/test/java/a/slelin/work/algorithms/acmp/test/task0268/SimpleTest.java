package a.slelin.work.algorithms.acmp.test.task0268;

import a.slelin.work.algorithms.acmp.task0268.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(5, 1, "abcde");
        assertEquals(12, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(3, 3, "aaa");
        assertEquals(6, result);
    }
}
