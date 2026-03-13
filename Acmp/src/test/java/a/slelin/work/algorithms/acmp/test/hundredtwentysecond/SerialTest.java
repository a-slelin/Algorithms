package a.slelin.work.algorithms.acmp.test.hundredtwentysecond;

import a.slelin.work.algorithms.acmp.hundredtwentysecond.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerialTest {

    @Test
    public void test1() {
        long result = Main.solve(6, new int[]{3, 29, 5, 5, 28, 6});
        assertEquals(3, result);
    }
}
