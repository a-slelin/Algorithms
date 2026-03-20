package a.slelin.work.algorithms.acmp.test.task0335;

import a.slelin.work.algorithms.acmp.task0335.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(4);
        assertEquals(204, result);
    }
}
