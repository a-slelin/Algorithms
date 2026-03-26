package a.slelin.work.algorithms.acmp.test.task0471;

import a.slelin.work.algorithms.acmp.task0471.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve(1);
        assertNotNull(result);
        assertEquals(new BigInteger("8"), result);
    }

    @Test
    public void test2() {
        BigInteger result = Main.solve(2);
        assertNotNull(result);
        assertEquals(new BigInteger("16"), result);
    }
}