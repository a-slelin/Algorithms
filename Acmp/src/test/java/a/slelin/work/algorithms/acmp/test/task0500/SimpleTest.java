package a.slelin.work.algorithms.acmp.test.task0500;

import a.slelin.work.algorithms.acmp.task0500.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(3, new int[][]{
                {6000, 2},
                {5500, 3},
                {5000, 4}
        });
        assertEquals(5, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(5, new int[][]{
                {5005, 1},
                {5004, 2},
                {5003, 3},
                {5002, 4},
                {5001, 5},
        });
        assertEquals(7, result);
    }
}
