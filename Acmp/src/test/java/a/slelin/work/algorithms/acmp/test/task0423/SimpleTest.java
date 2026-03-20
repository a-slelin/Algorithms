package a.slelin.work.algorithms.acmp.test.task0423;

import a.slelin.work.algorithms.acmp.task0423.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve("1025");
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(4), result);
    }

    @Test
    public void test2() {
        BigInteger result = Main.solve("21705");
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(3), result);
    }

    @Test
    public void test3() {
        BigInteger result = Main.solve("33222");
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(8), result);
    }
}
