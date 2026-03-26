package a.slelin.work.algorithms.acmp.test.task0470;

import a.slelin.work.algorithms.acmp.task0470.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        int result = Main.solve(new int[][]{
                {5, 1, 2},
                {6, 7, 3}}, 2, 1, 2, 3);
        assertEquals(16, result);
    }
}