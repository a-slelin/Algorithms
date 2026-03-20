package a.slelin.work.algorithms.acmp.test.task0114;

import a.slelin.work.algorithms.acmp.task0114.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve(2, 10);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(90), result);
    }

    @Test
    public void test2() {
        BigInteger result = Main.solve(4, 2);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(5), result);
    }

    @Test
    public void test3() {
        BigInteger result = Main.solve(6, 3);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(328), result);
    }
}
