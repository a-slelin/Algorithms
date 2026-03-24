package a.slelin.work.algorithms.acmp.test.task0666;

import a.slelin.work.algorithms.acmp.task0666.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        char result = Main.solve(4);
        assertEquals('w', result);
    }
}
