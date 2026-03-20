package a.slelin.work.algorithms.acmp.test.task0781;

import a.slelin.work.algorithms.acmp.task0781.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve(3);
        assertEquals(6, result);
    }
}
