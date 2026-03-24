package a.slelin.work.algorithms.acmp.test.task0011;

import a.slelin.work.algorithms.acmp.task0011.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve(1, 3);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void test2() {
        BigInteger result = Main.solve(2, 7);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(21), result);
    }

    @Test
    public void test3() {
        BigInteger result = Main.solve(3, 10);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(274), result);
    }
}
