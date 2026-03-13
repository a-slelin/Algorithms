package a.slelin.work.algorithms.acmp.test.hundredthirteenth;

import a.slelin.work.algorithms.acmp.hundredthirteenth.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FarmerTest {

    @Test
    public void test1() {
        long result = Main.solve(7, new int[][]{
                {1, 1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 0},
        });
        assertEquals(9, result);
    }
}
