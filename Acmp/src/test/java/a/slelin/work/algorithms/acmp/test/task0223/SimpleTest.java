package a.slelin.work.algorithms.acmp.test.task0223;

import a.slelin.work.algorithms.acmp.task0223.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve("TROT", "TORT");
        assertNotNull(result);
        assertEquals(new BigInteger("2"), result);
    }

    @Test
    public void test2() {
        BigInteger result = Main.solve("MADAM", "ADAMM");
        assertNotNull(result);
        assertEquals(new BigInteger("4"), result);
    }

    @Test
    public void test3() {
        BigInteger result = Main.solve("LONG", "GONG");
        assertNotNull(result);
        assertEquals(new BigInteger("0"), result);
    }

    @Test
    public void test4() {
        BigInteger result = Main.solve("AAAAAAAA", "AAAAAAAA");
        assertNotNull(result);
        assertEquals(new BigInteger("1430"), result);
    }
}