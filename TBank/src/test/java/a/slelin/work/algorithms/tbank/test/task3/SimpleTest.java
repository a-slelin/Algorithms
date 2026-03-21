package a.slelin.work.algorithms.tbank.test.task3;

import a.slelin.work.algorithms.tbank.task3.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve("0");
        assertEquals(0, result);
    }

    @Test
    public void test2() {
        long result = Main.solve("1");
        assertEquals(1, result);
    }

    @Test
    public void test3() {
        long result = Main.solve("011");
        assertEquals(2, result);
    }

    @Test
    public void test4() {
        long result = Main.solve("11011");
        assertEquals(6, result);
    }

    @Test
    public void test5() {
        long result = Main.solve("01101");
        assertEquals(2, result);
    }

    @Test
    public void test6() {
        long result = Main.solve("11111");
        assertEquals(25, result);
    }
}
