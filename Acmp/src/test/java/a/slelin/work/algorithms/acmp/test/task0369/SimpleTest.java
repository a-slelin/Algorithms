package a.slelin.work.algorithms.acmp.test.task0369;

import a.slelin.work.algorithms.acmp.task0369.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(4, 10,
                new int[]{10, 16, 8, 16},
                new int[]{10, 11, 15, 1},
                new int[]{10, 7, 1, 8}
        );
        assertEquals(26, result);
    }

    @Test
    public void test2() {
        int result = Main.solve(2, 17,
                new int[]{5, 0},
                new int[]{50, 33},
                new int[]{6, 1}
        );
        assertEquals(0, result);
    }
}