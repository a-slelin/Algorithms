package a.slelin.work.algorithms.acmp.test.task0123;

import a.slelin.work.algorithms.acmp.task0123.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve("????(?");
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(2), result);
    }
}
