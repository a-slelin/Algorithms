package a.slelin.work.algorithms.acmp.test.task0122;

import a.slelin.work.algorithms.acmp.task0122.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(6, new int[]{3, 29, 5, 5, 28, 6});
        assertEquals(3, result);
    }
}
