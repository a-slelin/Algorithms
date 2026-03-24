package a.slelin.work.algorithms.acmp.test.task0553;

import a.slelin.work.algorithms.acmp.task0553.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(3, new int[]{0, 34, 29, 4}, new int[]{0, 29, 4, 15});
        assertEquals(646, result);
    }
}