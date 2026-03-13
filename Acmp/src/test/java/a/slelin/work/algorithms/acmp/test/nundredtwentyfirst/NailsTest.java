package a.slelin.work.algorithms.acmp.test.nundredtwentyfirst;

import a.slelin.work.algorithms.acmp.hundredtwentyfirst.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NailsTest {

    @Test
    public void test1() {
        long result = Main.solve(6, new int[]{3, 4, 12, 6, 14, 13});
        assertEquals(5, result);
    }
}
