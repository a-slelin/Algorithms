package a.slelin.work.algorithms.acmp.test.task0787;

import a.slelin.work.algorithms.acmp.task0787.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(8, new int[]{3, 1, 4, 1, 5, 9, 2, 6});
        assertEquals(5, result);
    }
}
