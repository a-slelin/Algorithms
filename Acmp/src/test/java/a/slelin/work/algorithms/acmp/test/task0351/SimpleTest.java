package a.slelin.work.algorithms.acmp.test.task0351;

import a.slelin.work.algorithms.acmp.task0351.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(10, 2, "ABABBCACBC".toCharArray());
        assertEquals(2, result);
    }
}
