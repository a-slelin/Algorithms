package a.slelin.work.algorithms.acmp.test.task0680;

import a.slelin.work.algorithms.acmp.task0680.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(3);
        assertEquals(12, result);
    }
}
