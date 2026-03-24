package a.slelin.work.algorithms.acmp.test.task0960;

import a.slelin.work.algorithms.acmp.task0960.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve("abc");
        assertEquals(1, result);
    }

    @Test
    public void test2() {
        long result = Main.solve("ab");
        assertEquals(0, result);
    }
}
