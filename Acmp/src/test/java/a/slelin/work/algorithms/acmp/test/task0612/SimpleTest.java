package a.slelin.work.algorithms.acmp.test.task0612;

import a.slelin.work.algorithms.acmp.task0612.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleTest {

    @Test
    public void test1() {
        String result = Main.solve("abAaBBabbA", "AaBaba");
        assertNotNull(result);
        assertEquals("aAaBabaAbA", result);
    }
}
