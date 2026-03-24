package a.slelin.work.algorithms.acmp.test.task0481;

import a.slelin.work.algorithms.acmp.task0481.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        long result = Main.solve("AAA");
        assertEquals(7, result);
    }

    @Test
    public void test2() {
        long result = Main.solve("BAOBAB");
        assertEquals(22, result);
    }
}