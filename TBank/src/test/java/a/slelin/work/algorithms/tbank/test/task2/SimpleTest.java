package a.slelin.work.algorithms.tbank.test.task2;

import a.slelin.work.algorithms.tbank.task2.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve("tbankstudy");
        assertEquals(0, result);
    }

    @Test
    public void test2() {
        int result = Main.solve("studtbankk");
        assertEquals(5, result);
    }
}
