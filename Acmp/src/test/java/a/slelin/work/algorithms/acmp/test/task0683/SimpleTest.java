package a.slelin.work.algorithms.acmp.test.task0683;

import a.slelin.work.algorithms.acmp.task0683.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(5, new int[]{1, 50, 51, 50, 1});
        assertEquals(5301, result);
    }
}