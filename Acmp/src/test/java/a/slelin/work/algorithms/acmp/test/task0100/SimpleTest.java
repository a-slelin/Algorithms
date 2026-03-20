package a.slelin.work.algorithms.acmp.test.task0100;

import a.slelin.work.algorithms.acmp.task0100.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve(4);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(670), result);
    }

    @Test
    public void test2() {
        BigInteger result = Main.solve(6);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(55252), result);
    }

    @Test
    public void test3() {
        BigInteger result = Main.solve(12);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(39581170420L), result);
    }
}
