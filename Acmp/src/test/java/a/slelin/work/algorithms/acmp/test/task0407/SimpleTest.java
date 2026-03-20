package a.slelin.work.algorithms.acmp.test.task0407;

import a.slelin.work.algorithms.acmp.task0407.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(3, new int[]{1, 5, 7}, 19);
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(5, new int[]{7, 8, 9, 10, 11}, 13);
        assertEquals(-1, result);
    }
}
