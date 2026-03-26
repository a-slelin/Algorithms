package a.slelin.work.algorithms.acmp.test.task0812;

import a.slelin.work.algorithms.acmp.task0812.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve(2, 1);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(1), result);
    }

    @Test
    public void test2() {
        BigInteger result = Main.solve(4, 2);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(5), result);
    }
}
