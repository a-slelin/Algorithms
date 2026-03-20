package a.slelin.work.algorithms.acmp.test.task0179;

import a.slelin.work.algorithms.acmp.task0179.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve(3);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(28), result);
    }

    @Test
    public void test2() {
        BigInteger result = Main.solve(10);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(59050), result);
    }
}
