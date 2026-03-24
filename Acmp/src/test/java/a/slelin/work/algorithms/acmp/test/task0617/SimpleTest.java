package a.slelin.work.algorithms.acmp.test.task0617;

import a.slelin.work.algorithms.acmp.task0617.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;

public class SimpleTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve(3, 3, 2, 2);
        assertNotNull(result);
        assertEquals(new BigInteger("18"), result);
    }
}