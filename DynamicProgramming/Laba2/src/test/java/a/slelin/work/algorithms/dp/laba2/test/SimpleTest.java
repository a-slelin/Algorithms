package a.slelin.work.algorithms.dp.laba2.test;

import a.slelin.work.algorithms.dp.laba2.Algorithm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Базовые тесты из условий")
public class SimpleTest {

    @Test
    @DisplayName("Тест для 2 городов")
    public void test2Town() {
        Algorithm.Result result = Algorithm.solve(new int[][]{
                {0, 5},
                {0, 3}
        });
        assertNotNull(result);
        assertNotNull(result.getTotalDistance());
        assertEquals(5, result.getTotalDistance());
        assertNotNull(result.getTowns());
        assertEquals(List.of(0, 1), result.getTowns());
    }

    @Test
    @DisplayName("Тест для 3 городов")
    public void test3Town() {
        Algorithm.Result result = Algorithm.solve(new int[][]{
                {0, 10, 15},
                {10, 0, 20},
                {15, 20, 10}
        });
        assertNotNull(result);
        assertNotNull(result.getTotalDistance());
        assertEquals(30, result.getTotalDistance());
        assertNotNull(result.getTowns());
        assertEquals(List.of(0, 1, 2), result.getTowns());
    }

    @Test
    @DisplayName("Тест для 4 городов")
    public void test4Town() {
        Algorithm.Result result = Algorithm.solve(new int[][]{
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0},
        });
        assertNotNull(result);
        assertNotNull(result.getTotalDistance());
        assertEquals(65, result.getTotalDistance());
        assertNotNull(result.getTowns());
        assertEquals(List.of(0, 1, 3, 2), result.getTowns());
    }
}
