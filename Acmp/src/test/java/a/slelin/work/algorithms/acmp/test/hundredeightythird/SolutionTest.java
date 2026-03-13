package a.slelin.work.algorithms.acmp.test.hundredeightythird;

import a.slelin.work.algorithms.acmp.hundredeightythird.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void test1() {
        long result = Main.solve(4, 10);
        assertEquals(2, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(8, 10);
        assertEquals(5, result);
    }

    @Test
    public void test3() {
        long result = Main.solve(360, 1000);
        assertEquals(179, result);
    }
}
