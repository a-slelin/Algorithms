package a.slelin.work.algorithms.acmp.test.task0872;

import a.slelin.work.algorithms.acmp.task0872.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(3, new String[]{"a", "ab", "abc"});
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(5, new String[]{"a", "ab", "bc", "bcd", "add"});
        assertEquals(2, result);
    }
}
