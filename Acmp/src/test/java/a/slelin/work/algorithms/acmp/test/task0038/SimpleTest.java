package a.slelin.work.algorithms.acmp.test.task0038;

import a.slelin.work.algorithms.acmp.task0038.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(new int[]{3, 2, 5, 4});
        assertEquals(1, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(new int[]{5, 5, 5, 5, 5, 5});
        assertEquals(0, result);
    }

    @Test
    public void test3() {
        int result = Main.solve(new int[]{2, 1, 3, 2, 9, 1, 2, 3, 1});
        assertEquals(2, result);
    }

    @Test
    public void test4() {
        int result = Main.solve(new int[]{2, 5, 3, 12, 4, 6, 13, 7, 1, 3});
        assertEquals(1, result);
    }
}
