package a.slelin.work.algorithms.acmp.test.hundredtwentythird;

import a.slelin.work.algorithms.acmp.hundredtwentythird.Main;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RestorationBracketsTest {

    @Test
    public void test1() {
        BigInteger result = Main.solve("????(?");
        assertNotNull(result);
        assertEquals(BigInteger.valueOf(2), result);
    }
}
