package a.slelin.work.algorithms.tbank.test.task1;

import a.slelin.work.algorithms.tbank.task1.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        String result = Main.solve("682902");
        assertNotNull(result);
        assertEquals("202689", result);
    }

    @Test
    public void test2() {
        String result = Main.solve("01");
        assertNotNull(result);
        assertEquals("10", result);
    }
}
