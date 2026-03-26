package a.slelin.work.algorithms.acmp.test.task0736;

import a.slelin.work.algorithms.acmp.task0736.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(10, 2, 1);
        assertEquals(0, result);

        result = Main.solve(10, 2, 2);
        assertEquals(1, result);

        result = Main.solve(10, 2, 3);
        assertEquals(6, result);

        result = Main.solve(10, 2, 5);
        assertEquals(8, result);

        result = Main.solve(10, 2, 10);
        assertEquals(5, result);

        result = Main.solve(10, 2, 5);
        assertEquals(8, result);
    }
}
