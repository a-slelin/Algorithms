package a.slelin.work.algorithms.acmp.test.task0186;

import a.slelin.work.algorithms.acmp.task0186.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(2, new int[]{1, 1_000_000_000});
        assertEquals(999_999_999, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(3, new int[]{1, 2, 3});
        assertEquals(2, result);
    }

    @Test
    public void test3() {
        int result = Main.solve(8, new int[]{1, 10, 100, 1000, 1000, 100, 10, 1});
        assertEquals(0, result);
    }

    @Test
    public void test4() {
        int result = Main.solve(10, new int[]{258, 740, 156, 244, 458, 680, 390, 694, 844, 817});
        assertEquals(102, result);
    }
}
