package a.slelin.work.algorithms.acmp.test.task0638;

import a.slelin.work.algorithms.acmp.task0638.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTest {

    @Test
    public void test1() {
        boolean[] badWeekdays = new boolean[8];
        badWeekdays[7] = true;

        boolean[] badDates = new boolean[32];
        badDates[1] = true;
        badDates[9] = true;

        int result = Main.solve(31, 3, 7, 7, badWeekdays, badDates);
        assertEquals(15, result);
    }
}
