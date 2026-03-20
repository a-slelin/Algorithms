package a.slelin.work.algorithms.acmp.test.task0104;

import a.slelin.work.algorithms.acmp.task0104.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTest {

    @Test
    public void test1() {
        boolean result = Main.solve("A*CDA", "ABBCDA");
        assertTrue(result);
    }
}
