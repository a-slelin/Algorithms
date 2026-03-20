package a.slelin.work.algorithms.acmp.test.task0176;

import a.slelin.work.algorithms.acmp.task0176.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve(3, 2);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(3), result);
    }

    @Test
    public void test2() {
        BigInteger result = Main.solve(37, 23);
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(203685956218528L), result);
    }
}
