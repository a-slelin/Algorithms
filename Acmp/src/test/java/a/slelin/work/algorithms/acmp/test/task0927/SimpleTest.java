package a.slelin.work.algorithms.acmp.test.task0927;

import a.slelin.work.algorithms.acmp.task0927.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve("22");
        assertEquals(2, result);
    }

    @Test
    public void test2() {
        int result = Main.solve("200");
        assertEquals(0, result);
    }

    @Test
    public void test3() {
        int result = Main.solve("1000");
        assertEquals(0, result);
    }

    @Test
    public void test4() {
        int result = Main.solve("239");
        assertEquals(16, result);
    }
}
