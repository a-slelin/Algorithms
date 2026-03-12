package a.slelin.work.algorithms.acmp.test.twentyninth;

import a.slelin.work.algorithms.acmp.twentyninth.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerGameTest {

    @Test
    public void test1() {
        long result = Main.solve(new int[]{1, 5, 10});
        assertEquals(9, result);
    }

    @Test
    public void test2() {
        long result = Main.solve(new int[]{1, 5, 2});
        assertEquals(3, result);
    }
}
