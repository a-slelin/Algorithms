package a.slelin.work.algorithms.acmp.test.hundredtwentieth;

import a.slelin.work.algorithms.acmp.hundredtwentieth.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinPathInTableTest {

    @Test
    public void test1() {
        long result = Main.solve(3, 4, new int[][]{
                {1, 1, 1, 1},
                {5, 2, 2, 100},
                {9, 4, 2, 1}
        });
        assertEquals(8, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(5, 5, new int[][]{
                {1, 1, 1, 1, 1},
                {3, 100, 100, 100, 100},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1}
        });
        assertEquals(11, result);
    }
}
