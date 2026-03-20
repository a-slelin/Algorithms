package a.slelin.work.algorithms.acmp.test.task0169;

import a.slelin.work.algorithms.acmp.task0169.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve(2, 4);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(2), result);
    }

    @Test
    public void test2() {
        BigInteger result = Main.solve(5, 5);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(1), result);
    }
}
