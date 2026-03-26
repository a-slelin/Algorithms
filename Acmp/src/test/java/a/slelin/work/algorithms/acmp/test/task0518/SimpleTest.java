package a.slelin.work.algorithms.acmp.test.task0518;

import a.slelin.work.algorithms.acmp.task0518.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(3, 6, new char[][]{
                "000".toCharArray(),
                "101".toCharArray(),
                "100".toCharArray()
        });
        assertEquals(5, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(2, 8, new char[][]{
                "01".toCharArray(),
                "10".toCharArray(),
        });
        assertEquals(0, result);
    }
}
